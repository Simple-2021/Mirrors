# Mirrors

> 人对着镜子说话，镜子不会回答。

> Plan ⟳: 存档对话

> Plan ⟳: 保持最新对话

## Plan X

![Mirrors-1](https://user-images.githubusercontent.com/78424351/185891925-483faa3b-b22e-495f-bb2e-0490c716a46c.png)

## Native API

> Pause

## Maven Package

> Kotlin

> SpringBoot

## 参考代码

> JQuery IOC

```JS

  $("className").method(param);

```
## 实现代码

> JS IOC

```JS

  function $(param){
    var tag=param[0];
    switch (tag){
      case "#":
        param=param.replace("#",'');
        return document.getElementById(param);
      default:
        return document.getElementByTagName(param);
    }
  }

```

## 参考资料

> Ideas By Bing

> Ideas By Google
