package com.lscs.lgs.annotationlib;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 *  编译时文件处理类
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes({"com.lscs.lgs.annotationlib.ContentView"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class ViewInjectProcessor extends AbstractProcessor {

    private Filer filer;
    Elements elementUtils;
    private int mLayoutId = -1;
    private String mClassFullName;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        filer = processingEnv.getFiler();
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        collectInfo(roundEnvironment);
//        writeToFile(typeElement);
        return true;
    }

    void collectInfo(RoundEnvironment roundEnv) {
        //获取注解为ContentView的对象
        for (Element element :  roundEnv.getElementsAnnotatedWith(ContentView.class)) {
                mLayoutId = element.getAnnotation(ContentView.class).value();//获取对象的值
                writeToFile((TypeElement) element);
        }
    }

    void writeToFile(TypeElement typeElement) {
        try {
            //创建构造方法,并初始化布局
            MethodSpec.Builder constructor = MethodSpec.constructorBuilder()
                    .addModifiers(Modifier.PUBLIC)
                    .addParameter(ParameterSpec.builder(TypeName.get(typeElement.asType()), "activity").build());
            constructor.addStatement("activity.setContentView($L)", mLayoutId );

            //创建编译时的类
            TypeSpec typeSpec = TypeSpec.classBuilder(typeElement.getSimpleName() + "$$ViewInjector")
                    .addModifiers(Modifier.PUBLIC)
                    .addMethod(constructor.build())
                    .build();

            String packageFullName = elementUtils.getPackageOf(typeElement).getQualifiedName().toString();
            JavaFile javaFile = JavaFile.builder(packageFullName, typeSpec)
                    .build();
            //            写成文件
            javaFile.writeTo(filer);
        } catch (Exception e) {

        }

    }
}
