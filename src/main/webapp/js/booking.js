/**
 * Created by Aleksej_home on 2015.07.27..
 */
$.noConflict();

$( document ).ready(function() {
   // $("nav").
     //   alert($(location).attr('pathname'));
    alert("Pops");
    $("#pete").text( "The DOM is now loaded and can be manipulated." );
});


function afterLoad() {
    alert( "Загрузка завершена: " + typeof(jQuery) );
}
/*document.onload = function(){
    alert("Pppppp");
}*/
