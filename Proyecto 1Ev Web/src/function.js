var reproducir_sonido = true;
var sonido_intro = new Audio("Original-Theme.wav");

function reproducirSonido(){
    if(reproducir_sonido){
        // Usamos la variable global
        sonido_intro.play();
        reproducir_sonido = false;
    }
}

// CÓDIGO PARA INICIAR EL AUDIO Y MOSTRAR LA WEB CON EVENTO SCROLL
document.addEventListener('DOMContentLoaded', () => {
    const splashScreen = document.getElementById('splash-screen');
    const arcadeContent = document.getElementById('arcade-content');

    // 1. Definir la función que maneja el inicio
    const iniciarSistema = () => {
        // Si ya se inició, salimos
        if (splashScreen.classList.contains('hidden')) return;

        // 2. Ejecuta la función de sonido
        reproducirSonido();

        // 3. Oculta la pantalla de inicio y muestra la web arcade
        splashScreen.style.opacity = '0';
        setTimeout(() => {
            splashScreen.classList.add('hidden');
            // Muestra el contenido principal de la arcade
            arcadeContent.classList.add('show-arcade');
            renderContent('home');
            // Elimina el listener de scroll para que no vuelva a intentar sonar
            window.removeEventListener('scroll', iniciarSistema);
        }, 500);
    };

    // 4. Asignar el listener de scroll al objeto window
    // El desplazamiento en la ventana es la interacción del usuario.
    window.addEventListener('scroll', iniciarSistema, { once: true });

    console.log("Web cargada. Esperando desplazamiento del usuario para reproducir sonido.");
});

const ENEMIES_DATA = [
    { id: 'orco', name: 'Orco', img: 'orco.jpg', hp: '50', dmg:'10',
        description: 'Un rudo guerrero encontrado en los caminos del bosque. Su fuerza es considerable y ataca sin piedad, pero su falta de defensa y técnica de bloqueo lo hace predecible. Es un enemigo de combate directo.' },
    { id: 'joma', name: 'JOMA', img: 'joma.jpg', hp: '100', dmg:'15',
        description: 'Una serpiente humanoide hechicera que mora en los pisos altos del castillo. Ataca desde el plano mental, confundiendo al héroe. Su poder radica en la magia y la ilusión.' },
    { id: 'sudosu', name: 'SudoSu', img: 'sudosu.jpg', hp: '150', dmg:'20',
        description: 'Acosumbra a sus víctimas con magia de somnolencia y lanza figuras de guerreros ancestrales. Es vulnerable al ruido.' },
    { id: 'aníd', name: 'Aníd', img: 'anid.jpg', hp: '200', dmg:'30',
        description: 'Un poderoso hechicero de origen gitano. Su magia es intensa y sus hechizos son difíciles de contrarrestar, requiriendo de la mayor destreza del héroe.' }
];

const CREATORS_DATA = [
    { id: 'dev1', name: 'Lothar', img: 'leo.jpg', role: 'Diseño de Juego y Lógica',
        description: 'Encargado de la mecánica central, las interacciones con el jugador y el equilibrio de las estadísticas de los enemigos.' },
    { id: 'dev2', name: 'Mordred', img: 'miguel.jpeg', role: 'Arte y Frontend CSS',
        description: 'Responsable de la estética retro, la paleta de colores, el manejo de la tipografía pixelada y la experiencia visual.' },
    { id: 'dev3', name: 'Mirelda', img: 'mireia.jpg', role: 'Diseño de Juego y Lógica',
        description: 'Coordinación del equipo y estructuración del sistema de navegación.' },
    { id: 'dev4', name: 'Alaric', img: 'alain.jpg', role: 'Diseño de Juego y Lógica',
        description: 'Encargado de la mecánica central, las interacciones con el jugador y el equilibrio de las estadísticas de los enemigos.' }
];

const APP_PAGES = {
    'home': {
        title: '------------------------------',
        content: `
            <div class="logo-container">
                <img src="logo.jpg" alt="Logo de Bienvenida" class="welcome-logo">
            </div>
        `
    },
    'history': {
        title: 'HISTORIA',
        content:
        `<p>
            Te despiertas una mañana cualquiera, abres los ojos lentamente mientras que observas como te encuentras cayendo al vacío;
            lo típico de cualquier mañ- Espera, algo no cuadra... Entras en pánico, agarrándote al colchón mientras te preguntas 
            cómo has acabado en tu situación. Nada te viene a la cabeza, cuando una voz te habla de la nada: "¡Saludos, estimado sujeto! 
            ¡Sea bienvenido a mi pequeño universo! Durante el día de hoy, o durante el resto de tu vida, depende de cuánto dure, te convertiré en un 
            personaje ficticio para que satisfagas mi insaciable aburrimien- ¿Qué se supone que estás haciendo...?" La confusión estaba escrita 
            por toda tu cara, no tenías ni idea de qué estaba pasando y estabas todavía aferrado a la cama. "Vale, veo que entiendes menos que un 
            crío en una clase de física cuántica. Vamos a ver... Yo te he invocado, oh héroe, porque una temible criatura ha ido a tu mundo y ha 
            secuestrado a tu persona más amada. Por eso te he invocado para que te embarques en esta aventura, blah blah..." <br><br>
            La voz sonaba cada vez más y más impaciente hasta que un estruendo retumbó el espacio. "¡Como sea! Buena suerte con eso, mucha mierda" 
            Fue entonces cuando empecé a caer a mayor velocidad, sentí como mi corazón iba a estallar a la que veía como en mitad de ese espacio vacío 
            aparecía un texto que leía "Legendar.ia". Algo me dice que esto va a ser una aventura digna de recordar... ¡Pero todavía no entiendo que hago aqui!
        </p>`
    },
    'characters': {
        title: 'PERSONAJES JUGABLES',
        content: `<p>
                -- Guerrero - HP: 125 DMG: 30 --<br><br>
                Un caballero armado capaz de aguantar ataques del enemigo. <br><br>{Inventario inicial: Espada, Escudo}<br><br>
                
                -- Mago - HP: 100 DMG: 40 --<br><br>
                Un hábil hechicero al que no le falta poder de ataque. <br><br>{Inventario inicial: Varita, Libro de Hechizos}<br><br>
                
                -- Helicoptero --<br><br>
                Una máquina de guerra, armada hasta arriba capaz de destruir todo a su camino... Siempre y cuando haya alguien pilotando. <br><br>{Inventario inicial: Vacío}<br><br>
                
                Hay rumores de que igual se encuentra un campeón secreto en alguna parte pero nadie lo ha sabido encontrar por 2 milenios.
                    </p>`
    },
    'creators': {
        title: 'FICHA TÉCNICA Y EQUIPO',
        // Ahora solo contiene la plantilla de la lista, que se llenará con CREATORS_DATA
        content: `<h3 style="margin-top:0;">Selecciona un Prisionero:</h3>
                  <div class="enemy-list creator-list">
                      ${CREATORS_DATA.map(c => `<button data-creator-id="${c.id}">${c.name}</button>`).join('')}
                  </div>
                  <p style="margin-top: 30px;">Versión 1.0 (Arcade Beta). Desarrollado en Madrid, 2025.</p>`
    },
    'enemies': {
        title: 'GALERÍA DE ENEMIGOS',
        // El contenido de la página 'enemies' se genera dinámicamente
        content: `<h3>Selecciona un Enemigo para Ver su Ficha:</h3>
                    <div class="enemy-list">
                            ${ENEMIES_DATA.map(e => `<button data-enemy-id="${e.id}">${e.name}</button>`).join('')}
                          </div>`
    }
};

const rightstuff = document.getElementById('rightstuff');

/**
 * Renderiza una página de contenido dentro de #rightstuff.
 * @param {string} pageId - El ID de la página (ej. 'home', 'enemies').
 */
function renderContent(pageId) {
    // Resetea el scroll al cambiar de página
    rightstuff.scrollTop = 0;

    const page = APP_PAGES[pageId] || APP_PAGES['home'];

    // Genera el HTML de la página
    const htmlContent = `
                <h3>[ ${page.title} ]</h3>
                <div class="page-content">${page.content}</div>
            `;
    rightstuff.innerHTML = htmlContent;

    // Si la página es 'enemies', asignamos listeners a los botones generados
    if (pageId === 'enemies') {
        document.querySelectorAll('.enemy-list button').forEach(button => {
            button.addEventListener('click', (event) => {
                const enemyId = event.currentTarget.dataset.enemyId;
                renderEnemyFicha(enemyId);
            });
        });
    }
        // *************************************************************
        // CLAVE: AGREGAR LA LÓGICA PARA ENLAZAR LOS BOTONES DE CREADORES
    // *************************************************************
    else if (pageId === 'creators') {
        // Seleccionamos los botones dentro del div .enemy-list (que es donde están)
        document.querySelectorAll('.enemy-list button').forEach(button => {
            button.addEventListener('click', (event) => {
                // Leemos el data-creator-id (el atributo que creaste en el HTML)
                const creatorId = event.currentTarget.dataset.creatorId;
                renderCreatorFicha(creatorId);
            });
        });
    }
}

function renderCreatorFicha(creatorId) {
    const creator = CREATORS_DATA.find(c => c.id === creatorId);
    if (!creator) return renderContent('creators');

    rightstuff.scrollTop = 0; // Resetea scroll

    const htmlContent = `
                <h3>[ FICHA: ${creator.name} ]</h3>
                <div class="enemy-ficha-container">
                    <!-- Las fichas de enemigo y creador comparten el mismo estilo -->
                    <img src="${creator.img}" alt="Imagen de ${creator.name}">
                    <p class="pixel-font" style="font-size: 10px; color: #69707e;">ROL: ${creator.role.toUpperCase()}</p>
                    <p>${creator.description}</p>
                    <button class="back-button" onclick="renderContent('creators')">
                        ← VOLVER
                    </button>
                </div>
            `;
    rightstuff.innerHTML = htmlContent;
}

/**
 * Renderiza la ficha de un enemigo específico.
 * @param {string} enemyId - El ID del enemigo (ej. 'skull').
 */
function renderEnemyFicha(enemyId) {
    const enemy = ENEMIES_DATA.find(e => e.id === enemyId);
    if (!enemy) return renderContent('enemies'); // Vuelve a la lista si no se encuentra

    rightstuff.scrollTop = 0; // Resetea scroll

    const htmlContent = `
                <h3>[ FICHA: ${enemy.name} ]</h3>
                <div class="enemy-ficha-container">
                    <img src="${enemy.img}" alt="Imagen de ${enemy.name}">
                    <p class="pixel-font" style="font-size: 10px; color: #69707e;">ID: ${enemy.id.toUpperCase()} - HP: ${enemy.hp.toUpperCase()} - DAÑO: ${enemy.dmg.toUpperCase()}</p>
                    <p>${enemy.description}</p>
                    <button class="back-button" onclick="renderContent('enemies')">
                        ← VOLVER
                    </button>
                </div>
            `;
    rightstuff.innerHTML = htmlContent;
}

document.addEventListener('DOMContentLoaded', () => {
    const splashScreen = document.getElementById('splash-screen');
    const arcadeContent = document.getElementById('arcade-content');
    const navButtons = document.querySelectorAll('.nav-button');

    // --- A. LÓGICA DE INICIO POR SCROLL ---
    const iniciarSistema = () => {
        if (splashScreen.classList.contains('hidden')) return;

        reproducirSonido();

        splashScreen.style.opacity = '0';
        setTimeout(() => {
            splashScreen.classList.add('hidden');
            arcadeContent.classList.add('show-arcade');
            renderContent('home'); // Muestra la página de inicio al cargar
            window.removeEventListener('scroll', iniciarSistema);
        }, 500);
    };

    window.addEventListener('scroll', iniciarSistema, { once: true });

    // --- B. NAVEGACIÓN PRINCIPAL ---
    navButtons.forEach(button => {
        button.addEventListener('click', (event) => {
            // El data-page contiene el ID de la página a cargar
            const pageId = event.currentTarget.dataset.page;
            renderContent(pageId);
        });
    });

    // Si el usuario hace clic en la pantalla de inicio (fallback de iOS/móviles)
    splashScreen.addEventListener('click', iniciarSistema, { once: true });

});