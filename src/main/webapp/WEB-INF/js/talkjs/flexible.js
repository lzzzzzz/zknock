  (function (doc, win) {
        var docEl = doc.documentElement,
            resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
            recalc = function () {
                var clientWidth = docEl.clientWidth;
                if (!clientWidth) return;
                if(clientWidth>=720){
                    docEl.style.fontSize = '100px';
                }else{
                    docEl.style.fontSize = 100 * (clientWidth / 720) + 'px';
                }
            };

        if (!doc.addEventListener) return;
        win.addEventListener(resizeEvt, recalc, false);
        doc.addEventListener('DOMContentLoaded', recalc, false);
    })(document, window);

  $(function(){

      /**复制链接*/
      var clipboard = new Clipboard('.right');

      //复制成功执行的回调，可选
      clipboard.on('success', function(e) {
          console.log("复制链接"+e);
      });

      //复制失败执行的回调，可选
      clipboard.on('error', function(e) {
          console.log("复制链接"+e);
      });
  });

