/**
 * Created by Aleksej_home on 2015.07.27..
 */
//$( document ).noConflict();

$( document ).ready(function() {
    $(".nav .active").attr("class","");
    $(".nav li a[href$=\""+$(location).attr('pathname')+"\"]").parent().attr("class", "active");
   // $("#slider").slider();
    $('#sandbox-container .input-daterange').datepicker({
        startDate: '-3d'
    });
});


function afterLoad() {
    alert( "Загрузка завершена: " + typeof(jQuery) );
}

//$("#slider_id").slider();
