
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
        if (index < this.lastIndexOf(char)) {
            index = this.lastIndexOf(char);
        }
    }
    if (index !== -1) {
        text = this.slice(-1 * this.length + index + 1);
        return this + (text.zh_CN() ? "。" : ".");
    }
    return this;
}
