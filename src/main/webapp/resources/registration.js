let newRecordId;
let addUrl = "app/registration/add";
let deleteUrl = "app/registration/delete";
let updateUrl = "app/registration/update";

function setUpdateForm(element){
    newRecordId = document.recordForm.id.value;
    trElement = document.getElementById(element);
    document.recordForm.id.value = element;
    document.recordForm.title.value = trElement.children[0].innerHTML;
    document.recordForm.releaseDate.value = trElement.children[1].innerHTML;
    document.recordForm.artistId.value = trElement.children[2].innerHTML;
    document.recordForm.labelId.value =  trElement.children[3].innerHTML;
    document.recordForm.created.value =  trElement.children[4].innerHTML;
    document.recordForm.modified.value =  trElement.children[5].innerHTML;
    document.recordForm.action = projectUrl + updateUrl;
}

function setAddForm(){
    document.recordForm.id.value = newRecordId;
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

