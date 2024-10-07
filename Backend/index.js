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
  database: "peliculas-android",
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