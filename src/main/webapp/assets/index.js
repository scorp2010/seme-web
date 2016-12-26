$(document).ready(function() {
    console.log("1111");

    // $("#video1").click(function() {
    //     console.log("1111222");
    //     if (video1.paused) {
    //         video1.play();
    //     } else {
    //         video1.pause();
    //     }
    // });


    // $("video").trigger("play"); //for auto play
    $("video").addClass('pause'); //for check pause or play add a class
    $('video').click(function() {
        if ($(this).hasClass('pause')) {
            $("video").trigger("play");
            $(this).removeClass('pause');
            $(this).addClass('play');
        } else {
            $("video").trigger("pause");
            $(this).removeClass('play');
            $(this).addClass('pause');
        }
    });


});
// var video1 = document.getElementById("video1");
//
// video1.onclick = function() {
//     if (video1.paused) {
//         video1.play();
//     } else {
//         video1.pause();
//     }
// }
