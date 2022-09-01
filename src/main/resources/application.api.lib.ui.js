const refresh = () => {
    $.get("/api", e => {
        const title = "Mirrors".padEnd(8) + e;
        if (title !== document.title) {
            if (index === count || index === (count - 1)) {
                index = count = e;
                refreshMirror();
            } else {
                count = e;
                document.title = title;
            }
        }
    });
}
const refreshMirror = () => {
    $.get("/api/mirror", e => {
        const json = JSON.parse(e);
        document.title = "Mirrors".padEnd(8) + json["K"];
        $("#Unit").placeholder = json["V"];
    });
}
const refreshMedia = (mediaQueryList) => {
    if (mediaQueryList === true || mediaQueryList.matches) {
        $("#favicon").href = "favicon.ico?dark=true";
    } else {
        $("#favicon").href = "favicon.ico";
    }
}