function setContainer(response){
    $("#CapsList").empty();
    $("#CapsList").html(response);
}

function listCapsDocente () {
    var id = $("#idpersona").val();
    $.ajax({
        url : "/antecedentePatologicoPersonal/list/" + id,
        method : 'GET',
        success : function(response){
            setContainer(response);
        },
        error : function(err){
            console.log(err);
        }
    });
}



