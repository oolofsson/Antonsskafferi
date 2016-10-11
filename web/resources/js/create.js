$(document).ready(function () {
    $("#logoutdiv").show();
        $("#imageuploaddiv").hide();
        $("#newalacartediv").hide();
        $("#deletealacartediv").hide();
        $("#newdrinkdiv").hide();
        $("#deletedrinkdiv").hide();
        $("#dailyspecialdiv").hide();
        $("#newdagensdiv").hide();
        $("#deletedagensdiv").hide();
        $("#ShowAlaCarte").hide();
        $("#PreAlaCarte").hide();
        $("#ShowLunch").hide();
        $("#PreLunch").hide();
        $("#HideAlaCarte").hide();
        $("#HideLunch").hide();
    
    $("#bildknapp").click(function(){
        $("#imageuploaddiv").show();
        $("#newalacartediv").hide();
        $("#deletealacartediv").hide();
        $("#newdrinkdiv").hide();
        $("#deletedrinkdiv").hide();
        $("#dailyspecialdiv").hide();
        $("#newdagensdiv").hide();
        $("#deletedagensdiv").hide();
        $("#ShowAlaCarte").hide();
        $("#PreAlaCarte").hide();
        $("#ShowLunch").hide();
        $("#PreLunch").hide();
        $("#HideAlaCarte").hide();
        $("#HideLunch").hide();
        
    });
    $("#alacarteknapp").click(function(){
        $("#newalacartediv").show();
        $("#deletealacartediv").show();
        $("#newdrinkdiv").show();
        $("#deletedrinkdiv").show();
        $("#dailyspecialdiv").hide();
        $("#imageuploaddiv").hide();
        $("#newdagensdiv").hide();
        $("#deletedagensdiv").hide();
        $("#PreAlaCarte").hide();
        $("#ShowAlaCarte").show();
        $("#PreAlaCarte").hide();
        $("#ShowLunch").hide();
        $("#PreLunch").hide();
        $("#HideAlaCarte").hide();
        $("#HideLunch").hide();
    });
    $("#dagensknapp").click(function(){
        $("#imageuploaddiv").hide();
        $("#newalacartediv").hide();
        $("#deletealacartediv").hide();
        $("#newdrinkdiv").hide();
        $("#deletedrinkdiv").hide();
        $("#newdagensdiv").show();
        $("#deletedagensdiv").show();
        $("#dailyspecialdiv").show();
        $("#ShowAlaCarte").hide();
        $("#PreAlaCarte").hide();
        $("#PreLunch").hide();
        $("#ShowLunch").show();
        $("#HideLunch").hide();
        $("#HideAlaCarte").hide();
        $("#HideLunch").hide();
    });
    $("#ShowAlaCarte").click(function(){
        $("#PreAlaCarte").show();
        $("#HideAlaCarte").show();
        $("#ShowAlaCarte").hide();
    });
    $("#HideAlaCarte").click(function(){
        $("#PreAlaCarte").hide();
        $("#HideAlaCarte").hide();
        $("#ShowAlaCarte").show();
    });
    
    $("#ShowLunch").click(function(){
        $("#PreLunch").show();
        $("#HideLunch").show();
        $("#ShowLunch").hide();
    });
    $("#HideLunch").click(function(){
        $("#PreLunch").hide();
        $("#HideLunch").hide();
        $("#ShowLunch").show();
    });
    $("#schemaknapp").click(function(){
       window.location.href = "javacalendar.jsp"; 
    });
    
    $("#delete_drink").change(function(){
        $('#delete_drink_form\\:input_drink').val($('#delete_drink').val());
    });
    
    $("#delete_alacarte").change(function(){
        $('#delete_alacarte_form\\:input_alacarte').val($('#delete_alacarte').val());
    });
    
    $("#delete_dagens").change(function(){
        $('#delete_dagens_form\\:input_dagens').val($('#delete_dagens').val());
    });
    
    $('.day_select').change(function(){
        for(var i = 1; i <= 7; i++){
           $('#daily_special_form\\:input' + i).val($('#select' + i).val());
        }
    });
});




