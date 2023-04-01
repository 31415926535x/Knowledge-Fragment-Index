<template>
  <v-container>
    <v-row class="text-center">
      <v-col class="mb-4">
        <h1 class="display-2 font-weight-bold mb-3">
          知识碎片聚合服务
        </h1>

        <v-form>
          <v-text-field v-model="savePayLoad.url" prepend-inner-icon="mdi-link" clearable label="url"
            hint="请输入一个url:(回车提交)" outlined :rules="[rules.required]" prepend-icon="mdi-vuetify">
          </v-text-field>

          <v-btn class="me-4" @click="submit">
            submit
          </v-btn>
        </v-form>

      </v-col>
      <v-col>
        <div>
          <v-table
            theme="dark"
            density="compact"
            fixed-header
            height="300px">
            <thead>
              <tr>
                <th class="text-left">
                  infoId
                </th>
                <th class="text-left">
                  infoType
                </th>
                <th class="text-left">
                  source
                </th>
                <th class="text-mid">
                  uri
                </th>
                <th class="text-left">
                  dataChangeCrateTime
                </th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="item in allUrlInfo" :key="item.infoId">
                <td>{{ item.infoId }}</td>
                <td>{{ item.infoType }}</td>
                <td>{{ item.source }}</td>
                <td> <a :href="item.uri">{{ item.uri }}</a></td>
                <td>{{ item.dataChangeCrateTime }}</td>
              </tr>
            </tbody>
          </v-table>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from 'axios'
export default {
  name: 'HelloWorld',

  data: () => ({
    rules: {
      required: value => !!value || 'Field is required'
    },
    savePayLoad: {
      url: ''
    },
    allUrlInfo: []
  }),
  created () {
    console.log('first load...')
    this.refreshAllTable()
  },
  methods: {
    submit () {
      console.log(233)
      alert(JSON.stringify(this.savePayLoad))
      axios.post('http://localhost:8080/knowledge/save', JSON.stringify(this.savePayLoad), {
        headers: {
          'Content-Type': 'application/json'
        }
      }).then(function (res) {
        if (res.data.code === 200) {
          console.log(res.data)
        }
        console.log(res.data.msg)
      }).catch(function (error) {
        console.log(error)
      })
      alert('2333')

      this.refreshAllTable()
    },
    refreshAllTable () {
      let that = this
      axios.post('http://localhost:8080/knowledge/queryAll', null, {
        headers: {
          'Content-Type': 'application/json'
        }
      }).then(function (res) {
        if (res.data.code === 200) {
          console.log(res.data)
          that.allUrlInfo = []
          that.allUrlInfo = res.data.data
          console.log(res.data.data)
          console.log(that.allUrlInfo)
        }
        console.log(res.data.msg)
      }).catch(function (error) {
        console.log(error)
      })
    }
  }
}
</script>
