<template>
  <div class="reco">
    <Row style="margin-bottom: 6px" type="flex" justify="center" align="middle" class="bg-title">
      <Col span="8">
        <h4 class="page-title">Book Recommendation</h4>
      </Col>
      <Col offset="8" span="8">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Search...">
          <b-button-group class="input-group-btn">
            <b-button>
              <Icon type="ios-search"/>
            </b-button>
          </b-button-group>
        </div>
      </Col>
    </Row>
    <Divider style="margin: 0;"></Divider>
    <Row :gutter="16" class="books" type="flex" justify="center" align="middle">
      <Col span="6">
        <div>
          <Card>
            <router-link :to="{name:'BookDetails'}">
              <b-card no-body class="overflow-hidden" style="max-width: 540px;">
                <b-row no-gutters>
                  <b-col md="6">
                    <b-card-img :src="backimg" class="rounded-0"/>
                  </b-col>
                  <b-col md="6">
                    <b-card-body title="Horizontal Card">
                      <b-card-text>
                        This is a wider card with supporting text as a natural lead-in to additional content.
                        This content is a little bit longer.
                      </b-card-text>
                    </b-card-body>
                  </b-col>
                </b-row>
              </b-card>
            </router-link>
          </Card>
        </div>
      </Col>
      <Col span="6">
        <div>
          <Card>
            <b-card no-body class="overflow-hidden" style="max-width: 540px;">
              <b-row no-gutters>
                <b-col md="6">
                  <b-card-img :src="backimg" class="rounded-0"/>
                </b-col>
                <b-col md="6">
                  <b-card-body title="Horizontal Card">
                    <b-card-text>
                      This is a wider card with supporting text as a natural lead-in to additional content.
                      This content is a little bit longer.
                    </b-card-text>
                  </b-card-body>
                </b-col>
              </b-row>
            </b-card>
          </Card>
        </div>
      </Col>
      <Col span="6">
        <div>
          <Card>
            <b-card no-body class="overflow-hidden" style="max-width: 540px;">
              <b-row no-gutters>
                <b-col md="6">
                  <b-card-img :src="backimg" class="rounded-0"/>
                </b-col>
                <b-col md="6">
                  <b-card-body title="Horizontal Card">
                    <b-card-text>
                      This is a wider card with supporting text as a natural lead-in to additional content.
                      This content is a little bit longer.
                    </b-card-text>
                  </b-card-body>
                </b-col>
              </b-row>
            </b-card>
          </Card>
        </div>
      </Col>
      <Col span="6">
        <div>
          <Card>
            <b-card no-body class="overflow-hidden" style="max-width: 540px;">
              <b-row no-gutters>
                <b-col md="6">
                  <b-card-img :src="backimg" class="rounded-0"/>
                </b-col>
                <b-col md="6">
                  <b-card-body title="Horizontal Card">
                    <b-card-text>
                      This is a wider card with supporting text as a natural lead-in to additional content.
                      This content is a little bit longer.
                    </b-card-text>
                  </b-card-body>
                </b-col>
              </b-row>
            </b-card>
          </Card>
        </div>
      </Col>
    </Row>
    <Row :gutter="16" class="books" type="flex" justify="center" align="middle">
      <Col span="6">
        <div>
          <Card>
            <b-card no-body class="overflow-hidden" style="max-width: 540px;">
              <b-row no-gutters>
                <b-col md="6">
                  <b-card-img :src="backimg" class="rounded-0"/>
                </b-col>
                <b-col md="6">
                  <b-card-body title="Horizontal Card">
                    <b-card-text>
                      This is a wider card with supporting text as a natural lead-in to additional content.
                      This content is a little bit longer.
                    </b-card-text>
                  </b-card-body>
                </b-col>
              </b-row>
            </b-card>
          </Card>
        </div>
      </Col>
      <Col span="6">
        <div>
          <Card>
            <b-card no-body class="overflow-hidden" style="max-width: 540px;">
              <b-row no-gutters>
                <b-col md="6">
                  <b-card-img :src="backimg" class="rounded-0"/>
                </b-col>
                <b-col md="6">
                  <b-card-body title="Horizontal Card">
                    <b-card-text>
                      This is a wider card with supporting text as a natural lead-in to additional content.
                      This content is a little bit longer.
                    </b-card-text>
                  </b-card-body>
                </b-col>
              </b-row>
            </b-card>
          </Card>
        </div>
      </Col>
      <Col span="6">
        <div>
          <Card>
            <b-card no-body class="overflow-hidden" style="max-width: 540px;">
              <b-row no-gutters>
                <b-col md="6">
                  <b-card-img :src="backimg" class="rounded-0"/>
                </b-col>
                <b-col md="6">
                  <b-card-body title="Horizontal Card">
                    <b-card-text>
                      This is a wider card with supporting text as a natural lead-in to additional content.
                      This content is a little bit longer.
                    </b-card-text>
                  </b-card-body>
                </b-col>
              </b-row>
            </b-card>
          </Card>
        </div>
      </Col>
      <Col span="6">
        <div>
          <Card>
            <b-card no-body class="overflow-hidden" style="max-width: 540px;">
              <b-row no-gutters>
                <b-col md="6">
                  <b-card-img :src="backimg" class="rounded-0"/>
                </b-col>
                <b-col md="6">
                  <b-card-body title="Horizontal Card">
                    <b-card-text>
                      This is a wider card with supporting text as a natural lead-in to additional content.
                      This content is a little bit longer.
                    </b-card-text>
                  </b-card-body>
                </b-col>
              </b-row>
            </b-card>
          </Card>

        </div>
      </Col>
    </Row>
  </div>
</template>

<script>
  import BButtonGroup from "bootstrap-vue/src/components/button-group/button-group";

  export default {
    name: "Recommendation",
    components: {BButtonGroup},
    data() {
      return {
        backimg: require('../../assets/images/books/book1.jpg'),
        books:[]
      }
    },
    methods:{
      getRecom:function(){
        this.$http({
          method: "GET",
          url: "http://localhost:8080/api/getAllBooks",
          emulateJSON: true
        }).then(
          function (response) {
            this.books = response.data;
            console.log(this.books);
          }, function (error) {
            console.log(error);
          }
        )
      },
    },
    created(){
      this.getRecom();
    }

  }
</script>

<style scoped>
  .books {
    margin-top: 10px;
  }

  .bg-title h4 {
    text-transform: uppercase;
    font-size: 14px;
    font-weight: 500;
    margin-top: 6px;
  }

  .bg-title {
    overflow: hidden;
    padding: 15px 10px 9px;
    margin-bottom: 25px;

  }

  .card-img {
    height: 100%;
  }
</style>
