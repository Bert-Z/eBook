<template>
  <div class="allordertable">
    <Card>
      <label>All Orders</label>
      <Table border :columns="columns" :data="data"></Table>
    </Card>
  </div>
</template>

<script>
  export default {
    name: "AllOrderTable",
    data: function () {
      return {
        columns: [
          {
            title: 'Bookid',
            key: 'booktitle'
          },
          {
            title: 'BuyNum',
            key: 'booknum'
          },
          {
            title: 'Time',
            key: 'createtime'
          }
        ],
        data: []
      }
    },
    methods: {
      getAllOrders(){
        this.$http({
          method: 'GET',
          url: 'http://localhost:8080/api/getAllOrders',
          emulateJSON: true
        }).then(
          function (response) {
            let info = response.data;
            console.log(info);
            for(let i in info){
              let item={
                id:info[i].id,
                booktitle:info[i].bookid,
                booknum:info[i].booknum,
                createtime:info[i].createtime
              };
              this.data.push(item);
            }
          }, function (error) {
            console.log(error);
          })
      },
      show(index) {
        this.$Modal.info({
          title: 'User Info',
          content: `Name：${this.data[index].name}<br>Age：${this.data[index].age}<br>Address：${this.data[index].address}`
        })
      }
    },
    created(){
      this.getAllOrders();
    }
  }
</script>

<style scoped>

</style>
