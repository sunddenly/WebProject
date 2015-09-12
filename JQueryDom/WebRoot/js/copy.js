$(
    function(){
        $('ul li:eq(2)').click(
            function (){
                $(this).css('font-size','30px');
            }
        );
        $('#a1').click(
            function(){
                var $obj = $('ul li:eq(2)').clone();
                $('ul').append($obj);
            }
        );
    }
);