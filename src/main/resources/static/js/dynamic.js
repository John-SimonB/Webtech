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
                <input type="checkbox" @change="toggleAll(items, $event.target.checked)" >
                <td>{{todos.todoField}}</td>
                <td>{{todos.dateField}}</td>
            </tr>
            <tr>
                <td><input type="checkbox" v.model="completed" ></td>
                <td>{{todoField}}</td>
                <td>{{dateField}}</td>
            </tr> 
        </tbody>
        </table>
`,
    data() {
        return {
            items: [],
            todoField: '',
            dateField: '',
           // owner: '',
        };
    },
    methods: {
        loadToDos() {
            axios.get('/todos')
                .then(response => (this.todos = response.data))
        },
        toggleAll(input, checked) {
            for (let key in input) {
                console.log(typeof input[key] === "boolean")
                if (typeof input[key] === "boolean") {
                    input[key] = checked
                }
            }
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