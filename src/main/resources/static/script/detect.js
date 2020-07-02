
function toValid() {
    let inputGroupFile = document.getElementById("inputGroupFile").value;
    let imageLinkId = document.getElementById("imageLinkId").value;

    if (isEmpty(imageLinkId)&&isEmpty(inputGroupFile)) {
        alert("Picture link or file is empty");
        return false;
    } else {
        return true;
    }
}


function isEmpty(str) {
    if (typeof str == null || str == "" || str == "undefined") {
        return true;
    } else {
        if (str.match(/^[ ]*$/)) {
            return true;
        }
        return false;
    }
}


function changeImageLink() {
    document.getElementById("inputGroupFile").value=null;
    document.getElementById("inputFileLabelId").innerHTML = 'Choose file';
}

function changeImageFile() {
    let inputGroupFile = document.getElementById("inputGroupFile").value;

    document.getElementById("inputFileLabelId").innerHTML = inputGroupFile;
    document.getElementById("imageLinkId").value = '';
}