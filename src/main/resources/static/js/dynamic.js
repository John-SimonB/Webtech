const app = Vue.createApp({})
app.component('button-counter', {
    data() {
        return {
            count: 0
        }
    },
    template: `
    <button @click="count++">
    Du hast mich {{ count }} mal geklickt!
    </button>`
})

app.mount('#components-demo')