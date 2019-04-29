<template>
  <div>
    <Card>
      <label>Shopping Cart</label>
      <Table border ref="selection" :columns="columns4" :data="data"></Table>
      <br/>
      <div style="text-align: right">
        <Button @click="handleSelectAll(true)">Set all selected</Button>
        <Button @click="handleSelectAll(false)">Cancel all selected</Button>
        <Button @click="checkout(false)">Checkout</Button>
      </div>
    </Card>
  </div>
</template>

<script>
  import {getCookie} from '../../util/util'

  export default {
    name: "ShoppingCartOrders",
    data: function () {
      return {
        columns4: [
          {
            type: 'selection',
            width: 60,
            align: 'center'
          },
          {
            title: 'Title',
            key: 'booktitle'
          },
          {
            title: 'Numbers',
            key: 'booknum'
          },
          {
            title: 'Action',
            key: 'action',
            align: 'center',
            render: (h, params) => {
              return h('div', [
                h('Button', {
                  props: {
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.show(params.index)
                    }
                  }
                }, 'View'),
                h('Button', {
                  props: {
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.remove(params.index)
                    }
                  }
                }, 'Delete')
              ]);
            }
          }
        ],
        data: []
      }
    },
    methods: {
      getcarts:function(){
        this.$http({
          method: 'GET',
          url: 'http://localhost:8080/api/getcarts?username=' + getCookie('name'),
          emulateJSON: true
        }).then(
          function (response) {
            let info = response.data;
            for(let i in info){
              let item={
                id:info[i].id,
                bookid:info[i].books[0].id,
                booktitle: info[i].books[0].booktitle,
                booknum:info[i].booknum
              };
              this.data.push(item);
            }
          }, function (error) {
            console.log(error);
          })
      },
      show(index) {
        // this.$Modal.info({
        //   title: 'User Info',
        //   content: `Name：${this.data[index].name}<br>Age：${this.data[index].age}<br>Address：${this.data[index].address}`
        // })
        this.$router.push({name:"BookDetails",query:{id:this.data[index].id}});
      },
      remove(index) {
        this.data.splice(index, 1);
      },
      handleSelectAll(status) {
        this.$refs.selection.selectAll(status);
      },
      checkout(){
        // console.log(this.$refs.selection.getSelection());
        var sel=this.$refs.selection.getSelection();
        var selrows=JSON.stringify(sel);
        // console.log(JSON.stringify(sel));
        // var arr=[];
        // for(let i in sel){
        //   arr.push(sel[i]);
        // }
        // this.checks=arr;
        // console.log(this.checks);
        let data={'username':getCookie('name'),'selrows':selrows};
        this.$http.post("http://localhost:8080/api/checkout",data,{emulateJSON: true}
        ).then(function(res){
          // console.log(res.data);
          // console.log(this.formCustom.name);
          if(res.data===1){
            this.$Message.success('Success!');
            this.$router.go(0);

          }else{
            this.$Message.error('Find user failed!');
          }
          console.log(res);

        },function(error){
          this.$Message.error('Fail!');
          console.log(error);
        })
        // console.log(data);
      }
    },
    created(){
      this.getcarts();
    }
  }
</script>

<style scoped>

</style>
