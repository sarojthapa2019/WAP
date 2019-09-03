var a = {
  name: "",
  log: function () {
    this.name = "Hello";
      console.log(this);
    //console.log(this.name);
    var setFrench = function (newname) {
      console.log("set French...")
      console.log(this);
      a.name = newname;
    };

    setFrench("Bonjour");
    console.log(this.name);
  }
};

a.log();
