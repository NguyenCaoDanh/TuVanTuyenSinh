function searchPosts() {
    var searchInput = document.getElementById("searchInput").value.toLowerCase();
    var tableRows = document.getElementsByTagName("tr");

    for (var i = 1; i < tableRows.length; i++) {
        var row = tableRows[i];
        var rowData = row.textContent.toLowerCase();

        if (rowData.includes(searchInput)) {
            row.style.display = "";
        } else {
            row.style.display = "none";
        }
    }
}

function delPost(path, idpost) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Something wrong!!!");
        });
    }
}
