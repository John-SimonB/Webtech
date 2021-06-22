const app = Vue.createApp({})
app.component('todos', {
    template: `
    <h1>Das sind deine Todos!</h1>
    <p></p>
    <div style="width: 50%; margin: 0px auto;">
    <input v-model="todoField" type="text" placeholder="Aufgabe" class="col-md-4 control-label" ref="todoInput"><a></a>
    <input v-model="dateField" type="date" placeholder="Deadline" class="col-md-4 control-label"><a></a>
    <button type="button" @click="save()" class="btn btn-success">Speichern</button>
    </div>
    <p>Solltest du ein ToDo erledigt haben, dann setz einfach ein Häkchen :)</p>
    <p></p>
    <h3>Erledigt: {{count}}</h3>
    <p></p>
    <table class="table table-dark">
        <thead>
        <tr>
            <th></th>
            <th>Aufgabe</th>
            <th>Deadline</th>
        </tr>
        </thead>
            <tbody>   
            <tr v-if="items.length === 0">
                <td></td>
                <td colspan="2" style="text-align:center">Es gibt gute Nachrichten! du hast keine Todos</td>
                <td></td>
            </tr>
            <tr v-for="todos in items">
                <td>{{todos.task}}</td>
                <td>{{todos.deadline}}</td>
            </tr>
            <tr>
                <td><input type="checkbox" v.model="completed" @click="count++"></td>
                <td>{{todoField}}</td>
                <td>{{dateField}}</td>
                <td><button type="button" @click="deletetodo(todo.id)" class="btn btn-danger">Löschen</button></td>
            </tr> 
        </tbody>
        </table>
`,
    data() {
        return {
            items: [],
            todoField: '',
            dateField: '',
            count: 0
           // owner: '',
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
            axios.delete('/item/'+id).then();
        }
        ,
        checkboxcheck(){

        },
        save() {
            axios.post('/todos', {
                task: this.todoField,
                deadline: this.dateField,
               // owner: this.owner
            })
                .then((response) =>{
                    this.todoField = '';
                    this.dateField = '';
                    this.$refs.todoInput.focus();
                    this.loadToDos();
                },  (error) => {
                    console.log('Das ToDo konnte nicht gespeichert werden');
                });
        },
    },
    mounted: function() {
        this.loadToDos();
    }
});
app.mount('#dynamic');