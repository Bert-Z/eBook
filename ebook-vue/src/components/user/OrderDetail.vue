<template>
  <div id="orderdetail">
    <Card>
      <div class="obligation" style="text-align: center">
        <h2 style="color: red">Obligation</h2>
      </div>
      <br/>
      <Divider></Divider>
      <label>Order Summary</label>
      <div class="ordersummary">
        <Table border :columns="columns" :data="data"></Table>
      </div>
      <Divider></Divider>
      <label>Consignee</label>
      <Table border :columns="consignee" :data="info"></Table>
      <Divider></Divider>
      <div style="text-align: right">
        <label style="color: red">Total Amount:</label>
        <div class="numbers">355$</div>
      </div>
      <Divider></Divider>
      <Row>
        <Col offset="21" span="3">
          <Button size="large" >Cancel</Button>
          <Button size="large" type="error">PayNow</Button>
        </Col>
      </Row>
    </Card>
  </div>
</template>

<script>
  export default {
    name: "OrderDetail",
    data() {
      return {
        columns: [
          {
            title: 'Name',
            key: 'name'
          },
          {
            title: 'Age',
            key: 'age'
          },
          {
            title: 'Address',
            key: 'address'
          }
        ],
        data: [
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
          },
          {
            name: 'Jim Green',
            age: 24,
            address: 'London No. 1 Lake Park',
          },
          {
            name: 'Joe Black',
            age: 30,
            address: 'Sydney No. 1 Lake Park',
          },
          {
            name: 'Jon Snow',
            age: 26,
            address: 'Ottawa No. 2 Lake Park',
          }
        ],
        consignee: [
          {
            title: 'Name',
            key: 'name'
          },
          {
            title: 'Age',
            key: 'age'
          },
          {
            title: 'Address',
            key: 'address'
          }
        ],
        info: [
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
          },
        ]
      }
    }
  }
</script>


<style scoped>

</style>
