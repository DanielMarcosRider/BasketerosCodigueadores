const express = require("express");
const cors = require('cors');
const app = express();
const bodyParser = require('body-parser');
app.use(cors());
const PORT = 3000;
const {Pool} = require("pg"); 

const myPool = new Pool({
  user: "postgres",
  host: "peliculas-android.cdzektqqammg.us-east-1.rds.amazonaws.com",
  database: "postgres",
  password: "baloncesto", // Considera usar variables de entorno para gestionar contraseñas
  port: 5432,
  ssl: {
    rejectUnauthorized: false, // Cambia a false si tienes problemas de certificados pero trata de evitarlo por seguridad
    // ca: fs.readFileSync('/path/to/server-ca.pem').toString(),
    // Es posible que AWS RDS requiera parámetros SSL específicos o archivos CA.
    // Comprueba la documentación de AWS RDS para obtener los detalles exactos.
  },
});


app.use(bodyParser.json());

app.listen(PORT, ()=> {
  console.log(`Servidor corriendo en http://localhost:${PORT}`);
});

app.get("/pelicula", async (req, res)=>{     // cualquier petición que venga de películas (luego son dos parámetros de pregunta(request) y respuesta (response))
  const {rows} = await myPool.query(        // mediante myPool se puede hacer la query sin necesidad de crear motores // en java no hace falta hacer async await porque ya ejecuta las cosas en segundo plano de serie
      "SELECT * FROM pelicula ORDER BY id;"
  );
  res.json(rows);
});


//update peliculas imagen
app.put("/pelicula", async (req, res) => {
  try {
      const {id, urlimagen } = req.body;
      
      // Verificar si se proporciona la nueva imagen
      if (!urlimagen) {
          return res.status(400).json({ error: "Nueva imagen no especificada" });
      }
      
      // Realizar la actualización en la base de datos
      await myPool.query(
          "UPDATE pelicula SET urlimagen = $1 WHERE id = $2",
          [urlimagen, id]
      );

      res.status(200).json({ message: "Imagen actualizada correctamente" });
  } catch (error) {
      console.error("Error al actualizar la imagen:", error);
      res.status(500).json({ error: "Error interno del servidor" });
  }
});


// login
app.post('/login', async (req, res) => {
  const { username, token } = req.body;

  try {
      const user = await myPool.query('SELECT * FROM usuario WHERE username = $1 AND token = $2', [username, token]);

      if (user.rows.length === 1) {
          // Usuario autenticado correctamente
          res.status(200).json({ message: 'Inicio de sesión exitoso', user: user.rows[0] });
      } else {
          // Credenciales incorrectas
          res.status(401).json({ error: 'Credenciales incorrectas' });
      }

  } catch (error) {
      console.error('Error al iniciar sesión:', error);
      res.status(500).json({ error: 'Error interno del servidor' });
  }
});

