AFRAME.registerComponent('redirect-mosque-on-click', {
  init: function () {
    var el = this.el;
    el.addEventListener('click', function () {
      new_link = window.location.href + "mosque";
      window.location.href = new_link;
    });
  }
});

AFRAME.registerComponent('redirect-khalifa-on-click', {
  init: function () {
    var el = this.el;
    el.addEventListener('click', function () {
      new_link = window.location.href + "khalifa";
      window.location.href = new_link;
    });
  }
});

AFRAME.registerComponent('redirect-palace-on-click', {
  init: function () {
    var el = this.el;
    el.addEventListener('click', function () {
      new_link = window.location.href + "palace";
      window.location.href = new_link;
    });
  }
});

AFRAME.registerComponent('redirect-ferarri-on-click', {
  init: function () {
    var el = this.el;
    el.addEventListener('click', function () {
      new_link = window.location.href + "ferarri";
      window.location.href = new_link;
    });
  }
});

AFRAME.registerComponent('redirect-arab-on-click', {
  init: function () {
    var el = this.el;
    el.addEventListener('click', function () {
      new_link = window.location.href + "arab";
      window.location.href = new_link;
    });
  }
});
