/**
 * 添加监听要在flash和html5环境中分开添加。所以添加了二次监听。
 */
function loadedHandler(){
    var ck = CKobject.getObjectById('ckplayer_a1');
    if(ck.getType()){
        alert('播放器已加载，调用的是HTML5播放模块');
        ck.addListener('play',playHandler);
        ck.addListener('pause',pauseHandler);
    }
    else{
        alert('播放器已加载，调用的是Flash播放模块');
        ck.addListener('play','playHandler');
        ck.addListener('pause','pauseHandler');

    }
}


function playHandler(){
    var status = CKobject.getObjectById('ckplayer_a1').getStatus();
    var time1 = CKobject.getObjectById('ckplayer_a1').getStatus().time;
    var timestamp = Date.parse(new Date());
    var newDate = new Date();
    newDate.setTime(timestamp);
    console.log(status)
    console.log('播放了,时间是' + time1 + '当前时间为：' + newDate);
    //alert('播放了,' + '播放时间是');
}

function pauseHandler() {
    var newDate = new Date();
    var time2 = CKobject.getObjectById('ckplayer_a1').getStatus().time;
    console.log("暂停了,时间是" + time2)
    // alert('暂停了');
}

