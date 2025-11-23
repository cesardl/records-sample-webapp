let newRecordId = 0;
let addUrl = "app/registration/add";
let deleteUrl = "app/registration/delete";
let updateUrl = "app/registration/update";

function setUpdateForm(element) {
    let releaseDate = $("#record-releaseDate-" + element).text();
    let created = $("#record-created-" + element).text();
    let modified = $("#record-modified-" + element).text();

    newRecordId = document.recordForm.id.value;
    let trElement = document.getElementById(element);

    document.recordForm.id.value = element;
    document.recordForm.title.value = trElement.children[0].innerHTML;
    $('#releaseDate').attr("value", releaseDate);
    document.recordForm.artistId.value = trElement.children[2].innerHTML;
    document.recordForm.labelId.value = trElement.children[3].innerHTML;
    $('#created').attr("value", created);
    $('#modified').attr("value", modified);
    document.recordForm.deleteRecord.disabled = false;
    document.recordForm.action = projectUrl + updateUrl;
}

function setAddForm() {
    document.recordForm.id.value = 0;
    document.recordForm.title.value = "";
    document.recordForm.releaseDate.value = "";
    document.recordForm.artistId.value = "";
    document.recordForm.labelId.value = "";
    document.recordForm.created.value = "";
    document.recordForm.modified.value = "";
    document.recordForm.newRecord.disabled = true;
    document.recordForm.deleteRecord.disabled = true;
    document.recordForm.action = projectUrl + addUrl;
}

function setDeleteForm() {
    document.recordForm.action = projectUrl + deleteUrl;
    return true;
}
