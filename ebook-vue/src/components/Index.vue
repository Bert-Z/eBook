<template>
  <div id="index" class="layout">
    <Layout>
      <Header :style="{position: 'fixed', width: '100%',background:'#fff',padding:'0'}">
        <common-nav></common-nav>
      </Header>

      <Content>

      </Content>

      <Footer>

      </Footer>
    </Layout>
  </div>
</template>

<script>
  import CommonNav from "./common/CommonNav";

  export default {
    name: "Index",
    components: {CommonNav}
  }
</script>

<style scoped>
  .layout{
    border: 1px solid #d7dde4;
    /*background: #f5f7f9;*/
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
</style>
