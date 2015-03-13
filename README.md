# NestedFragmentActivityResult

An example of [StatedFragment](https://github.com/nuuneoi/StatedFragment) on **How to fix `onActivityResult` problem of nested fragment from not being called**

First of all, add a dependency for `StatedFragment`

```
compile 'com.inthecheesefactory.thecheeselibrary:stated-fragment-support-v4:0.9.2'
// Or use the above line instead, in case you use Fragment from android.app.*
//compile 'com.inthecheesefactory.thecheeselibrary:stated-fragment:0.9.2'
```

Override your Activity's `onActivityResult` and add the following line:

```java
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ActivityResultBus.getInstance().postQueue(new ActivityResultEvent(requestCode, resultCode, data));
    }
```

That's all. You can now wait for an Activity Result from standard `onActivityResult` inside your fragment.

```java
   @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Add your code here
        Toast.makeText(getActivity(), "Fragment Got it: " + requestCode + ", " + resultCode, Toast.LENGTH_SHORT).show();
    }
```

For the source code of StateFragment, go to https://github.com/nuuneoi/StatedFragment
