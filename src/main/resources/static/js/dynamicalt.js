const app = Vue.createApp({})
app.component('todos', {
    template: `
      <p></p>
      <div class="box">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <br>
      <div class="text">Solltest du ein ToDo erledigt haben, dann setz einfach ein Häkchen <img src="image/emoji.png" width="20" height="20" alt="emoji" loading="lazy"></div>
      <div style="width: 50%; margin: 0px auto;">
        <p></p>
        <label class="custom-field three">
          <input v-model="todoField" type="text" placeholder="&nbsp;"  ref="todoInput" required autofocus/> <a></a>
          <span class="placeholder"></span>
          <span class="border"></span>
        </label>
        <label class="custom-field three">
          <input id="datefield" v-model="dateField" @click="date()" type="date" min="" placeholder="Deadline" /> <a></a>
          <span class="border"></span>
        </label>
        <label>
          <button type="button" @click="save()" class="btn primary shinny">Speichern</button>
        </label>
        <br>
      </div>
      </div>
      <br>
      <br>
      <br>
      <br>
      <div class="box">
      <p></p>
      <table class="table">
        <thead class="thead-dark">
        <tr>
          <th></th>
          <th>Aufgabe</th>
          <th>Deadline</th>
          <th></th>
        </tr>
        </thead>
        <tbody>
        <tr v-if="items.length === 0">
          <td></td>
          <td colspan="2" style="text-align:center">Es gibt gute Nachrichten! du hast keine Todos</td>
          <td></td>
        </tr>
        <tr v-for="todo in items">
          <td><label class="custom-checkbox" tab-index="0" aria-label="Checkbox Label">
            <input type="checkbox" checked>
            <span class="checkmark"></span>
            <span class="label"></span>
          </label></td>
          <td><span class="label">{{todo.task}}</span></td>
          <td><span class="label">{{todo.deadline}}</span></td>
          <td><button class="btntrash" @click="deletetodo(todo.id)"><i class="fa fa-trash"></i></button></td>
        </tr>
        </tbody>
      </table>
      </div>
    `,
    data() {
        return {
            items: [],
            todoField: '',
            dateField: '',
            count: 0
        };
    },
    methods: {
        date() {
            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth()+1; //January is 0 so need to add 1 to make it 1!
            var yyyy = today.getFullYear();
            if(dd<10){
                dd='0'+dd
            }
            if(mm<10){
                mm='0'+mm
            }

            today = yyyy+'-'+mm+'-'+dd;
            document.getElementById("datefield").setAttribute("min", today);
        },
        checkboxclick () {
            const x = document.getElementById("checkbox");
            const y = document.getElementById("checkbox1");
            x.classList.toggle('checkedLabel')
            y.classList.toggle('checkedLabel')
        },
        loadToDos() {
            axios.get('/rest/todos')
                .then(response => {
                    this.items = response.data
                    console.log(response.data)
                })
        },
        checkbox() {
            if(this.checkbox().checked) {
                count ++
            }
        },
        deletetodo(idjetzt) {
            axios.delete('/rest/deletetodo/' + idjetzt)
                .then(response => {
                    this.loadToDos()
                    this.items.splice(id, 1);
                    console.log(this.items);
                });
        },
        save() {
            axios.post('/todos', {
                task: this.todoField,
                deadline: this.dateField,
            })
                .then((response) =>{
                    this.todoField = '';
                    this.dateField = '';
                    this.$refs.todoInput.focus();
                    this.loadToDos();},  (error) => {
                    console.log('Das ToDo konnte nicht gespeichert werden');
                });
        },
    },
    mounted: function() {
        this.loadToDos();
    }
});
app.mount('#dynamic');