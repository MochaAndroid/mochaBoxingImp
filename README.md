### boxing-impl

此项目核心库为bilibili 的[boxing](https://github.com/Bilibili/boxing)，在此基础上结合抹茶App 的实际情况定制出的图片选择库。

### Usage

- gradle

```groovy
   compile('com.mocha:boxing_imp:0.3.0') {
          exclude group: 'com.android.support'
          exclude module: 'recyclerview-v7'
      }
```

  为了不重复引用依赖，使用时可以排除掉support 包以及recyclerView。

### Geting started

选择单张图片

```java
  public static void choosePic(Activity activity, int requestCode) {
        IBoxingMediaLoader loader = new FrescoLoader(activity);
       //图片的加载库，我们用的fresco
        BoxingMediaLoader.getInstance().init(loader);

        BoxingConfig singleImgConfig = new BoxingConfig(BoxingConfig.Mode.SINGLE_IMG)
                .needCamera(R.drawable.ic_boxing_camera_white)
                .withMediaPlaceHolderRes(R.drawable.ic_boxing_default_image);

        Boxing.of(singleImgConfig).withIntent(activity, BoxingActivity.class)
                .start(activity, requestCode);
    }
```

选择多张图片

```java
 IBoxingMediaLoader loader = new FrescoLoader(uiContainer.getContext());
        BoxingMediaLoader.getInstance().init(loader);

        BoxingConfig config = new BoxingConfig(BoxingConfig.Mode.MULTI_IMG)
                .needCamera(R.drawable.ic_boxing_camera_white)
                .withMaxCount(maxPicCount);
        Boxing.of(config)
                .withIntent(uiContainer.getContext(), BoxingActivity.class)
                .start(uiContainer.getActivity(), requestCode);
```

### Update

现在使用的boxing 版本为0.7.0，之后如果想要更新的话直接修改build.gradle 里的版本号就好了。

```groovy
compile('com.bilibili:boxing:0.7.0') {
        exclude group: 'com.android.support'
    }
```



















### 写在最后

如果你看到这里，说明……



你看到了这里





嗯 ，希望抹茶越来越好吧！
