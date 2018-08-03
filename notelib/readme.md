访问本地的video 并返回数据   :        IntentUtils

                        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent, 0);

存储图片后把图片加入相册   :    IntentUtils
        Uri localUri = Uri.fromFile(new File(path));
        Intent localIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, localUri);
        context.sendBroadcast(localIntent);


解决fragment重叠问题      :FragNavController
    :每次初始化fragment管理类e的时候都先移除原来的fragment
    :关键代码
            if (mFragmentManager.getFragments() != null) {
                FragmentTransaction ft = mFragmentManager.beginTransaction();
                ft.setTransition(mTransitionMode);
                for (Fragment fragment : mFragmentManager.getFragments()) {
                    ft.remove(fragment);
                }
                ft.commit();
                executePendingTransactions();
            }