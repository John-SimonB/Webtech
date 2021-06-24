const alert = {
    init() {
        this.hideTimeout = null;

        this.el = document.createElement('div');
        this.el.className = 'alert';
        document.body.appendChild(this.el);
    },

    showalert(message, state) {
        clearTimeout(this.hideTimeout);
        this.el.textContent = message;
        this.el.className = 'alert alert--visible';

        if(state) {
            this.el.classList.add('alert--${state}');
        }

        this.hideTimeout = setTimeout(() => {
            this.el.classList.remove('alert--visible');
        }, 3000);
    }
};

document.addEventListener('DOMContentLoaded', () => alert.init());
