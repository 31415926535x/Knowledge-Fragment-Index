<template>
  <v-container>
    <v-row class='text-center'>
      <v-col class='mb-4'>
        <h1 class='display-2 font-weight-bold mb-3'>
          知识碎片聚合服务
        </h1>

        <v-form class="">
          <v-text-field
            v-model='savePayLoad.url'
            prepend-inner-icon='mdi-link'
            clearable
            label='url'
            hint='请输入一个url:(回车提交)'
            outlined
            :rules='[rules.required]'
            prepend-icon='mdi-vuetify'
          >
          </v-text-field>

          <v-btn class='me-4' @click='submit'>
            submit
          </v-btn>
        </v-form>
      </v-col>
      <v-col>
        <v-data-table
          v-model="selected"
          :headers='headers'
          :items="allUrlInfo"
          :items-per-page="10"
          class='elevation-1'
        ></v-data-table>
      </v-col>
    </v-row>
  </v-container>

</template>

<script>
import axios from 'axios'
export default {
  name: 'HelloWorld',

  data: () => ({
    selected: [],
    headers: [
      {text: 'infoId', value: 'infoId', sortable: false},
      {text: 'infoType', value: 'infoType'},
      {text: 'title', value: 'title'},
      {text: 'author', value: 'author'},
      {text: 'uri', value: 'uri'},
      {text: 'summary', value: 'summary'},
      {text: 'dataChangeCrateTime', value: 'dataChangeCrateTime'}
    ],
    rules: {
      required: value => !!value || 'Field is required'
    },
    savePayLoad: {
      url: ''
    },
    allUrlInfo: []
  }),
  mounted () {
    console.log('first load...')
    this.refreshAllTable()
  },
  methods: {
    submit () {
      console.log(233)
      alert(JSON.stringify(this.savePayLoad))
      axios
        .post(
          'http://localhost:8080/knowledge/save',
          JSON.stringify(this.savePayLoad),
          {
            headers: {
              'Content-Type': 'application/json'
            }
          }
        )
        .then(function (res) {
          if (res.data.code === 200) {
            console.log(res.data)
          }
          console.log(res.data.msg)
        })
        .catch(function (error) {
          console.log(error)
        })
      alert('2333')

      this.refreshAllTable()
    },
    refreshAllTable () {
      let that = this
      axios
        .post('http://localhost:8080/knowledge/queryAll', null, {
          headers: {
            'Content-Type': 'application/json'
          }
        })
        .then(function (res) {
          if (res.data.code === 200) {
            console.log(res.data)
            that.allUrlInfo = []
            that.allUrlInfo = res.data.data
            console.log(res.data.data)
            console.log(that.allUrlInfo)
          }
          console.log(res.data.msg)
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>
