<template>
  <div>
  <h4 class="page-title">User List</h4>
    <Table border ref="selection" :columns="columns4" :data="data1"></Table>
    <div style="float: left">
        <Button @click="handleSelectAll(true)">Set all selected</Button>
        <Button @click="handleSelectAll(false)">Cancel all selected</Button>
    </div>
    <div style="float: right">
        <Button @click="forbidden()" type="warning">Forbidden</Button>
        <Button @click="permit()" type="success">Permit</Button>
        <Button @click="setAdmin()" type="info">SetAdmin</Button>
        <Button @click="setUsers()" type="info">SetUsers</Button>
    </div>
  </div>
</template>

<script>

  export default {
    name: "Authorization",
    data() {
      return {
        columns4: [
          {
            type: 'selection',
            width: 60,
            align: 'center'
          },
          {
            title: 'Id',
            key: 'id',
            sortable: true
          },
          {
            title: 'Name',
            key: 'name',
            sortable: true
          },
          {
            title: 'Email',
            key: 'email',
            sortable: true
          },
          {
            title: 'Gender',
            key: 'gender',
            sortable: true
          },
          {
            title: 'Phone',
            key: 'phonenumber',
            sortable: true
          },
          {
            title: 'IsForbidden',
            key: 'isforbidden',
            sortable: true
          },
          {
            title: 'IsAdmin',
            key: 'isadmin',
            sortable: true
          }
        ],
        data1: []
      }
    },
    methods: {
      handleSelectAll(status) {
        this.$refs.selection.selectAll(status);
      },
      getAllUsers() {
        this.$http({
          method: 'GET',
          url: 'http://localhost:8080/admin/getAllUsers',
          emulateJSON: true
        }).then(
          function (response) {
            let info = response.data;
            // console.log(info);
            // for (let i in info) {
            //   let item = {
            //     id: info[i].orderid,
            //     booktitle: info[i].booktitle,
            //     booknum: info[i].booknum,
            //     bookfee:info[i].bookfee,
            //     createtime: info[i].updatetime
            //   };
            //   this.data.push(item);
            // }
            this.data1=info;
            // console.log(info);
          }, function (error) {
            console.log(error);
          })
      },
      forbidden(){
        var sel=this.$refs.selection.getSelection();
        var selrows=JSON.stringify(sel);
        // console.log(selrows);
        let data={'selrows':selrows};
        this.$http.post("http://localhost:8080/admin/forbidden",data,{emulateJSON: true}
        ).then(function(res){
          // console.log(res.data);
          // console.log(this.formCustom.name);
          if(res.data===1){
            this.$Message.success('Success!');
            this.getAllUsers();
          }else{
            this.$Message.error('Forbidden Fail!');
          }
          console.log(res);

        },function(error){
          this.$Message.error('Fail!');
          console.log(error);
        })
      },
      permit(){
        var sel=this.$refs.selection.getSelection();
        var selrows=JSON.stringify(sel);
        // console.log(selrows);
        let data={'selrows':selrows};
        this.$http.post("http://localhost:8080/admin/permit",data,{emulateJSON: true}
        ).then(function(res){
          // console.log(res.data);
          // console.log(this.formCustom.name);
          if(res.data===1){
            this.$Message.success('Success!');
            this.getAllUsers();
          }else{
            this.$Message.error('Permit Fail!');
          }
          console.log(res);

        },function(error){
          this.$Message.error('Fail!');
          console.log(error);
        })
      },
      setAdmin(){
        var sel=this.$refs.selection.getSelection();
        var selrows=JSON.stringify(sel);
        // console.log(selrows);
        let data={'selrows':selrows};
        this.$http.post("http://localhost:8080/admin/setAdmin",data,{emulateJSON: true}
        ).then(function(res){
          // console.log(res.data);
          // console.log(this.formCustom.name);
          if(res.data===1){
            this.$Message.success('Success!');
            this.getAllUsers();
          }else{
            this.$Message.error('Set Admin Fail!');
          }
          console.log(res);

        },function(error){
          this.$Message.error('Fail!');
          console.log(error);
        })
      },
      setUsers(){
        var sel=this.$refs.selection.getSelection();
        var selrows=JSON.stringify(sel);
        // console.log(selrows);
        let data={'selrows':selrows};
        this.$http.post("http://localhost:8080/admin/setUsers",data,{emulateJSON: true}
        ).then(function(res){
          // console.log(res.data);
          // console.log(this.formCustom.name);
          if(res.data===1){
            this.$Message.success('Success!');
            this.getAllUsers();
          }else{
            this.$Message.error('Set Users Fail!');
          }
          console.log(res);

        },function(error){
          this.$Message.error('Fail!');
          console.log(error);
        })
      },
    },
    mounted(){
      this.getAllUsers();
    },
  }
</script>

<style scoped>

</style>
