const app = document.getElementById('typewriter');
const typewriter = new Typewriter(app, {loop: false, delay: 150});
typewriter
        .typeString('ByteTech: La potencia de la tecnología en tus manos')
        .pauseFor(3000)
        .start();

function goBack() {
  history.back();

}
function verContraseña() {
    var passwordInput = document.getElementById('password');
    var toggleButton = document.getElementById('togglePassword');

    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        toggleButton.innerHTML = '<i class="bi bi-eye-slash-fill"></i>';
    } else {
        passwordInput.type = 'password';
        toggleButton.innerHTML = '<i class="bi bi-eye-fill"></i>';
    }
}