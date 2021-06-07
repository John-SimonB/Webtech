const app = Vue.createApp({});
app.component('dynamic', {
    template: `
    <div>
        <input v-model="nameField" placeholder="Aufgabe" ref="nameInput">
        <input v-model="dateField" oncanplay="Deadline" @keyup.enter="save()">
        <button type="button" @click="save()">Speichern</button>
    </div>
    <div>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">Aufgabe</th>
                    <th scope="col">Deadline</th>
                    <th scope="col">Status</th>
                </tr>
            </thead>
        <tbody>
            <tr v-if="items.length === 0">
                <td>Es sind keine ToDos vorhanden!</td>
            </tr>
            <tr v-for="ToDoListEntity in items">
                <td>{{ToDoListEntity.task}}</td>
                <td>{{ToDoListEntity.deadline}}</td>
                <td>{{ToDoListEntity.state}}</td>
            </tr>
            <tr>
                <td>{{ nameField }}</td>
                <td>{{ dateField }}</td>
            </tr>
        <tbody>
    </table>
</div>
`,
    data() {
        return {
            items: [],
            nameField: '',
            dateField: '',
        };
    },
    methods: {
        loadTodos() {
            axios.get('/todos')
                .then(response => (this.items = response.data()))
        },
        save() {
            axios.post('/todos', {
                task: this.nameField,
                deadline: this.dateField,
                active: false,
                owner: "",
            })
            .then((response) => {
                this.nameField = '';
                this.dateField = '';
                this.$refs.nameInput.focus();
                this.loadTodos();
            }, (error) => {
                console.log('Das ToDo konnte nicht gespeichert werden!');
            });
        },
    },
    mounted: function () {
        this.loadTodos();
    }
});
app.mounted('#dynamic');