const uploadMirror = files => {
    const form = new FormData();
    for (i of files) {
        form.append("file", i);
    }
    $.post("/api/upload", form, () => {
        alert("upload succeed");
    }, () => {
        alert("upload failed");
    });
}
const downloadMirror = (filename) => {
    const tag = document.createElement("a");
    const download = "/api/download?file=";
    tag.download = filename;
    tag.href = download + filename;
    tag.click();
    tag.remove();
}