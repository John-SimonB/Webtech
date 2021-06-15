const app = Vue.createApp({})
app.component('todos', {
    template: `
    <h1>Das sind deine Todos!</h1>
    <p></p>
    <div style="width: 50%; margin: 0px auto;">
    <input v-model="newtodo" type="text" placeholder="Aufgabe" class="col-md-4 control-label" ref="todoInput"><a></a>
    <input v-model="date" type="date" placeholder="Deadline" class="col-md-4 control-label"><a></a>
    <button type="button" @click="save()" class="btn btn-success">Speichern</button>
    </div>
    <p></p>
    <table class="table table-dark">
        <thead>
        <tr>
            <th>Aufgabe</th>
            <th>Deadline</th>
        </tr>
        </thead>
            <tbody>
                <tr v-if="todos.length === 0">
            <td colspan="2" style="text-align:center">Es gibt gute Nachrichten! du hast keine Todos</td>
        </tr>
            <tr v-for="product in todos">
                <td>{{toDoListEntity.newtodo}}</td>
                <td>{{toDoListEntity.date}}</td>
            </tr>
            <tr>
                <td>{{newtodo}}</td>
                <td>{{date}}</td>
            </tr>
        </tbody>
        </table>
`,
    data() {
        return {
            todos: [],
            newtodo: '',
            date: '',
            active: '',
            owner: '',
        };
    },
    methods: {
        loadToDos() {
            axios.get('/todos')
                .then(response => (this.items = response.data))
        },
        save() {
            axios.post('/todos', {
                todo: this.newtodo,
                date: this.date,
                active: this.active,
                owner: this.owner
            })
                .then((response) =>{
                    this.newtodo = '';
                    this.date = '';
                    this.active = '';
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