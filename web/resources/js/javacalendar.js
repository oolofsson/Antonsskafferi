$(function(){
    
    $("#adminknapp").click(function(){
       window.location.href = "create.xhtml"; 
    });
    
    $(".event1_select").change(function(){
        var event1str = $(".event1_select").val();
        var event1arr = event1str.split(".");
        $(".event1_id_input").val(event1arr[0]);
        $(".sender_id_input").val(event1arr[1]);
    });
    
    $(".event2_select").change(function(){
        var event2str = $(".event2_select").val();
        var event2arr = event2str.split(".");
        $(".event2_id_input").val(event2arr[0]);
        $(".receiver_id_input").val(event2arr[1]);
    });
    
    
    $(".waiter_select").change(function(){
        var waiterStr = $(".waiter_select").val();
        var waiterArr = waiterStr.split(".");
        $(".waiter_id_input").val(waiterArr[0]);
        $(".event_text_input").val(waiterArr[1]);
        $(".color_input").val(getColorCode(waiterArr[0])); //Generate color
        $("#datepicker").show();
    });
    
    //Datepicker init
    $( "#datepicker" ).datepicker({ 
      dayNamesMin: ['S&ouml', 'M&aring', 'Ti', 'On', 'To', 'Fr', 'L&ouml'],
      monthNames: ['Januari', 'Februari', 'Mars', 'April', 'Maj', 'Juni', 'Juli', 'Augusti', 'September','Oktober', 'November', 'December'],
      firstDay: 1
    });
    
    $('#datepicker').datepicker('option', 'dateFormat', 'yy-mm-dd');
    $(".event_time_select").hide(); //Time select hidden before date is selected
    $(".event_time_select_from").hide();
    $(".event_time_select_to").hide();
    $("#datepicker").hide();
    $('.event_submit').prop('disabled', true);
    
    $("#datepicker").change(function(){
        var day = $("#datepicker").datepicker('getDate').getDay();
        
        if(day < 5){ //monday - thursday
            $(".event_time_select").show();
            $(".event_time_select_from").hide();
            $(".event_time_select_to").hide();
            $(".event_time_select").val('default'); //Välj Tid
        }else{
            $(".event_time_select").hide();
            $(".event_time_select_from").show();
            $(".event_time_select_from").val('default'); //Välj Tid
            loadTimeStamps(".event_time_select_from", 11);
        }
        $('.event_submit').prop('disabled', true); //always disabled if time is not picked        
    });
    
    $(".event_time_select").change(function(){
       
       var timeStr = $(".event_time_select").val();
       var timeArr = timeStr.split(".");
        
       $(".event_start_date_input").val($("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' }).val() + " " + timeArr[0]);
       $(".event_end_date_input").val($("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' }).val() + " " + timeArr[1]);
       $('.event_submit').prop('disabled', false);
       
    });
    
    $(".event_time_select_from").change(function(){
        $(".event_time_select_to").show();
        $(".event_time_select_to").val('default'); //Välj Tid
        $('.event_submit').prop('disabled', true);
        loadTimeStamps(".event_time_select_to", parseInt($(".event_time_select_from").val().substring(0, 2)) + 1);
    });
    $(".event_time_select_to").change(function(){
        $(".event_start_date_input").val($("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' }).val() + " " + $(".event_time_select_from").val());
        $(".event_end_date_input").val($("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' }).val() + " " + $(".event_time_select_to").val());
        
        $('.event_submit').prop('disabled', false);
        
    });
    
});

getColorCode = function(id){ //change for better color variation?
    var colorCode = "#";
    for(var i = 0; i < 6; i++){
        if(i % 2 === 0)
            colorCode += Number(id) * (i + 1);
        else
            colorCode += Number(id) + 4 * i;
    }
    return colorCode.substr(0, 7);
}
loadTimeStamps = function(element, startTime){
    
    var output = [];
    
    if(element === ".event_time_select_from")
        output.push('<option value="default" selected="true" disabled="true" >V&auml;lj starttid...</option>');
    else
        output.push('<option value="default" selected="true" disabled="true" >V&auml;lj sluttid...</option>');
    
    for(var timeIndex = startTime; timeIndex <= 24; timeIndex++)
        output.push('<option value="'+ timeIndex + ":00:00" +'">'+ timeIndex + ":00" +'</option>');
    
    $(element).html(output.join(''));
}