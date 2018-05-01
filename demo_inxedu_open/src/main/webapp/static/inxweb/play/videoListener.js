/**
 * 添加监听要在flash和html5环境中分开添加。所以添加了二次监听。
 */
function loadedHandler(){
    var ck = CKobject.getObjectById('ckplayer_a1');
    var userId = getLoginUser().userId;
    // console.log(userId);
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
    var userId = getLoginUser().userId;
    var eventName = '播放';
    var status = CKobject.getObjectById('ckplayer_a1').getStatus();
    var timePlay = CKobject.getObjectById('ckplayer_a1').getStatus().time;
    var timestamp = Date.parse(new Date());
    var newDate = new Date();
    newDate.setTime(timestamp);
    var fileLocation = CKobject.getObjectById('ckplayer_a1').getStatus().myflashvars.f;

    //console.log(status);
    console.log('播放了');
    //alert('播放了,' + '播放时间是');

    addLog(logArray, userId, timePlay, eventName, newDate, fileLocation);
    console.log(logArray);
}

function pauseHandler() {
    var userId = getLoginUser().userId;
    var eventName = '暂停';
    var totalTime = CKobject.getObjectById('ckplayer_a1').getStatus().totalTime;
    var timeStop = CKobject.getObjectById('ckplayer_a1').getStatus().time;
    var timestamp = Date.parse(new Date());
    var newDate = new Date();
    newDate.setTime(timestamp);
    var fileLocation = CKobject.getObjectById('ckplayer_a1').getStatus().myflashvars.f;
    console.log("暂停了");
    addLog(logArray, userId, timeStop, eventName, newDate, fileLocation);
    console.log(timeStop + '   ' + totalTime)
    // console.log(logArray);
    if(timeStop >= parseInt(totalTime)){
        console.log('播放结束');
        logArray.splice(0, logArray.length);
        console.log(logArray);
        console.log(getLoginUser());
    }else {
        console.log(logArray);
    }
    // alert('暂停了');

}

/**
 * 日志接收类
 * @param userId
 * @param videoTime
 * @param eventName
 * @param creationTime
 * @param fileLocation
 * @constructor
 */
function Log(userId, videoTime, eventName, creationTime, fileLocation) {
    this.userId = userId;
    this.videoTime = videoTime;
    this.eventName = eventName;
    this.creationTime = creationTime;
    this.fileLocation = fileLocation;

    this.getUserId = function () {
        return this.userId;
    }
    this.getVideoTime = function() {
        return this.videoTime;
    };
    this.getEventName = function() {
        return this.eventName;
    };
    this.getCreationTime = function() {
        return this.creationTime;
    };
    this.getFileLocation = function() {
        return this.fileLocation;
    }
}

/**
 * 增加一条事件
 * @param userId
 * @param logArray
 * @param videoTime
 * @param eventName
 * @param creationTime
 * @param fileLocation
 */
function addLog(logArray, userId, videoTime, eventName, creationTime, fileLocation) {
    var log = new Log(userId, videoTime, eventName, creationTime, fileLocation);
    logArray.push(log);
}

// /**
//  * 获取登录学员
//  * @returns {*}
//  */
// function getLoginUser(){
//     var user = null;
//     $.ajax({
//         url:baselocation+'/uc/getloginUser',
//         type:'post',
//         async:false,
//         dataType:'json',
//         success:function(result){
//             user = result.entity;
//         }
//     });
//     return user;
// }
