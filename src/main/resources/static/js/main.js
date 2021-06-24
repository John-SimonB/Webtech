import Dynamic from './dynamic';

const app = Vue.createApp({});
app.component('dynamic', Dynamic);
app.mount('#dynamic');