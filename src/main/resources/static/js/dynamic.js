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
    <input v-model="todoField" type="text" placeholder="Aufgabe" class="col-md-4 control-label" ref="todoInput"> <a></a>
    <input v-model="dateField" type="date" placeholder="Deadline" class="col-md-4 control-label"> <a></a>
    <button type="button" @click="save()" class="btn btn-success">Speichern</button>
    </div>
    </div>
    <br>
    <br>
    <br>
    <br>
    <div class="box">  
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
            <tr v-for="todos in items">
                <td><input type="checkbox" v.model="completed" @click="count++"></td>
                <td>{{todos.task}}</td>
                <td>{{todos.deadline}}</td>
                <td><button class="btntrash" @click="deletetodo(item.id)">ID VOM TODO: {{todos.id}}<i class="fa fa-trash"></i></button></td>            
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
        loadToDos() {
            axios.get('/rest/todos')
                .then(response => {
                    this.items = response.data
                    console.log(response.data)
                })
        },
        toggleAll(input, checked) {
            for (let key in input) {
                console.log(typeof input[key] === "boolean")
                if (typeof input[key] === "boolean") {
                    input[key] = checked
                }
            }
        },
        deletetodo() {
            axios.delete('/rest/deletetodo/' + this.items.id)
                .then(response => {
                    this.items.splice(id, 1);
                    this.loadToDos();
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