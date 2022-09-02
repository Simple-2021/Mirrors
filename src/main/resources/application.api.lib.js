const $ = e => {
    switch (e.charAt(0)) {
        case "#":
            return document.getElementById(e.slice(1));
        case ".":
            return document.getElementsByClassName(e.slice(1));
        default:
            return document.getElementsByTagName(e);
    }
}
$.select = (callback, isDirectory) => {
    const tag = document.createElement("input");
    tag.formEnctype = "multipart/form-data";
    tag.type = "file";
    if (isDirectory) {
        tag.webkitdirectory = true;
    }
    tag.multiple = true;
    tag.click();
    tag.onchange = () => {
        callback(tag.files);
        tag.remove();
    }
}
$.post = (url, data, success, fail) => {
    const xhr = new XMLHttpRequest();
    xhr.open("post", url);
    xhr.send(data);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                success(xhr.response);
            } else {
                fail(xhr.response);
            }
        }
    }
}
$.get = (url, success, fail) => {
    const xhr = new XMLHttpRequest();
    xhr.open("get", url);
    xhr.send()
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                success(xhr.response);
            } else {
                fail(xhr.response);
            }
        }
    }
}
//
Object.prototype.placeholder = function () {
    return this.attributes.getNamedItem("placeholder").value;
}
String.prototype.firstUpperCase = function () {
    if (this.length > 0) {
        return this[0].toUpperCase() + this.slice(1);
    }
    return "";
}
String.prototype.zh_CN = function () {
    let cn = 0, en = 0;
    for (let char of this) {
        char.charCodeAt(0) > 255 ? cn++ : en++;
    }
    return cn >= en;
}
String.prototype.appendPunctuation = function () {
    const chars = ",.!?，。？！…";
    let index = -1;
    let text = this;
    for (let char of chars) {
        if (this.slice(-1) !== char) {
            if (index < this.lastIndexOf(char)) {
                index = this.lastIndexOf(char);
            }
        }
    }
    if (index !== -1) {
        text = this.slice(-1 * this.length + index + 1);
        return this + (text.zh_CN() ? "。" : ".");
    }
    return this;
}
