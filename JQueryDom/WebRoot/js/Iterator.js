$(
    function(){
        $('#a1').click(
          function(){
              //var $obj = $('#d1').children('div');
             // alert($obj.length);
             // $obj.css('font-size','60px');

              //$('#d3').next().css('font-size','60px');
              $('div').next('p').css('font-size','60px');

             //$('#d3').prev().css('font-size','60px');

             //$('#d3').siblings().css('font-size','60px');
              //$('#d3').siblings('div').css('font-size','60px');

             //$('#d1').find('p').css('font-size','60px');
             //alert($('#d3').parent().attr('id'));
          }
        );
    }
);