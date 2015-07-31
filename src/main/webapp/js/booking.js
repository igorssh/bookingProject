/**
 * Created by Aleksej_home on 2015.07.27..
 */
//$( document ).noConflict();

$( document ).ready(function() {
    $(".nav .active").attr("class","");
    $(".nav li a[href$=\""+$(location).attr('pathname')+"\"]").parent().attr("class", "active");
    $("#ex2").slider({});
    $("#pdisc").change(function() {
        var org;
        switch(parseInt($(this).val())) {
            case 1:
                org = "glyphicon glyphicon-sort";break;
            case 2:
                org = "glyphicon glyphicon-sort-by-order";break;
            case 3:
                org = "glyphicon glyphicon-sort-by-order-alt";break;
            default:
            org = "glyphicon glyphicon-sort";
        }
        $("#optimizer  #sel_obj>span").attr("class", org);

    });

  /*  $('#sandbox-container .input-daterange').datepicker({
        startDate: '-3d'
    });*/
});


function afterLoad() {
    alert( "Загрузка завершена: " + typeof(jQuery) );
}

//$("#slider_id").slider();

/*$( ".dropdown > button.dropdown-toggle" ).change(function() {
    alert( "Handler for .change() called." );
});*/
