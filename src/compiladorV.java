
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextArea;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ll322
 */
public class compiladorV extends javax.swing.JFrame {
private Map<String, Integer> frecuenciaClasificaciones = new HashMap<>();
private TreeMap<String, String> tablaDeSimbolos = new TreeMap<>(); // Crea un arbol para la tabla de simbolos
private Map<String, String> idToToken = new HashMap<>(); // Mapa para mapear IDs a tokens correspondientes
private int contadorIds = 0;
private TreeMap<String, TreeMap<String, String>> construirArbolSintactico(String texto) {
    TreeMap<String, TreeMap<String, String>> arbolesSintacticos = new TreeMap<>();

    StringTokenizer tokenizer = new StringTokenizer(texto, "\n");

    String nombreArbolActual = null;
    TreeMap<String, String> arbolActual = null;

    while (tokenizer.hasMoreTokens()) {
        String linea = tokenizer.nextToken().trim();

        // Ignorar líneas en blanco o comentarios
        if (linea.isEmpty() || linea.startsWith("//")) {
            continue;
        }

        // Detectar si la línea marca el inicio de un nuevo árbol sintáctico
        if (nombreArbolActual == null || linea.startsWith("?")) {
            nombreArbolActual = "Arbol_" + (arbolesSintacticos.size() + 1); // Nombre del nuevo árbol sintáctico
            arbolActual = new TreeMap<>();
            arbolesSintacticos.put(nombreArbolActual, arbolActual);
        }

        // Detectar si la línea marca el final del árbol sintáctico actual
        if (linea.endsWith("$")) {
            nombreArbolActual = null;
            arbolActual = null;
            continue; // Pasar a la siguiente línea sin procesarla como parte del árbol sintáctico
        }

        // Si estamos dentro de un árbol sintáctico, agregar la línea como un nodo
        if (arbolActual != null) {
            // Agregar la línea como un nodo al árbol sintáctico actual
            arbolActual.put(linea, null);
        }
    }

    return arbolesSintacticos;
}

    /**
     * Creates new form compiladorV
     */
    public compiladorV() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        analizar = new javax.swing.JButton();
        cargarArch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ingresoTexto = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        salida = new javax.swing.JTextArea();
        Salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        tSimbolos = new javax.swing.JButton();
        mostrarArbol = new javax.swing.JButton();
        btnTipo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Léxico - Carlos González Y Salvador Martínez");
        setBackground(new java.awt.Color(102, 102, 255));
        setForeground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ANALIZADOR LÉXICO");

        analizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        analizar.setText("ANALIZAR");
        analizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarActionPerformed(evt);
            }
        });

        cargarArch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cargarArch.setText("CARGAR");
        cargarArch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cargarArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchActionPerformed(evt);
            }
        });

        ingresoTexto.setColumns(20);
        ingresoTexto.setRows(5);
        jScrollPane1.setViewportView(ingresoTexto);

        salida.setColumns(20);
        salida.setRows(5);
        jScrollPane2.setViewportView(salida);

        Salir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Salir.setText("SALIR");
        Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        limpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        limpiar.setText("LIMPIAR");
        limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        tSimbolos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tSimbolos.setText("T. Símbolos");
        tSimbolos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSimbolosActionPerformed(evt);
            }
        });

        mostrarArbol.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mostrarArbol.setText("ÁRBOL");
        mostrarArbol.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mostrarArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarArbolActionPerformed(evt);
            }
        });

        btnTipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTipo.setText("TIPO");
        btnTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(573, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cargarArch, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(analizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(mostrarArbol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tSimbolos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(analizar)
                        .addGap(18, 18, 18)
                        .addComponent(cargarArch)
                        .addGap(18, 18, 18)
                        .addComponent(limpiar)
                        .addGap(18, 18, 18)
                        .addComponent(mostrarArbol)
                        .addGap(18, 18, 18)
                        .addComponent(btnTipo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tSimbolos)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchActionPerformed
        // TODO add your handling code here:
        
        try {
            // Seleccionar el archivo
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                // Leer el contenido del archivo
                FileReader fileReader = new FileReader(selectedFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                StringBuilder content = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    // Agregar cada línea al contenido
                    content.append(line).append("\n"); 
                }

                // Cerrar el lector
                bufferedReader.close();

                // Asignar el contenido al JTextField
                ingresoTexto.setText(content.toString());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Imprimir el seguimiento de la pila en caso de excepción
        }
    }//GEN-LAST:event_cargarArchActionPerformed

    private boolean esPalabraClave(String token) {
    // Lista de palabras clave de Java
    String[] palabrasClave = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
                              "class", "const", "continue", "default", "do", "double", "enum",
                              "extends", "final", "finally", "float", "for", "goto", "implements",
                              "import", "instanceof", "int", "interface", "long", "native", "new", "package",
                              "private", "protected", "public", "return", "short", "static", "strictfp",
                              "super", "switch", "synchronized", "this", "throw", "throws", "transient",
                              "try", "void", "volatile", "String", "true", "false", "null"};
    return Arrays.asList(palabrasClave).contains(token);
    }

    private boolean esCondicional(String token) {
        // Lista de palabras que indican condicionales
        String[] condicionales = {"if", "else", "switch", "case", "default"};
        return Arrays.asList(condicionales).contains(token);
    }

    private boolean esCiclo(String token) {
        // Lista de palabras que indican ciclos
        String[] ciclos = {"for", "while", "do"};
        return Arrays.asList(ciclos).contains(token);
    }

    private boolean esOperador(String token) {
        // Lista de operadores
        String[] operadores = {"+", "-", "*", "/", "%", "=", "==", "!=", ">", "<", ">=", "<=", "&&", "||", "!", "&", "|", "^", "<<", ">>", ">>>", "~"};
        return Arrays.asList(operadores).contains(token);
    }

    private boolean esSimbolo(String token) {
        // Lista de símbolos
        String[] simbolos = {"(", ")", "{", "}", "[", "]", ",", ".", ";", ":", "?", "::"};
        return Arrays.asList(simbolos).contains(token);
    }
    
    private boolean esIdentificador(String token) {
        // Utiliza una expresión regular para verificar si es un identificador válido
        return token.matches("[a-zA-Z_]+[a-zA-Z0-9_]*") && !token.contains(".");
    }
    
    private boolean esNumero(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }
    
    private String obtenerClasificacion(String token) {
        // Devuelve la clasificación del token basada en diferentes criterios. (operadores ternarios)
        return esPalabraClave(token) ? "Palabra Clave" :
               esSimbolo(token) ? "Simbolo" :
               esCondicional(token) ? "Condicional" :
               esCiclo(token) ? "Ciclo" :
               esOperador(token) ? "Operador" :
               esIdentificador(token) ? "Identificador" :
               esNumero(token) ? "Número" :
               "Otro";
    }

private boolean verificarSintaxisLinea(String linea, int numeroLinea) {
    if (linea.trim().startsWith("//")) {
        return true; // La línea es un comentario y no necesita punto y coma
    }

    // Verificar si la línea contiene una estructura de control que debería estar seguida por una llave de apertura
    if (linea.matches("\\s*(if|for|while|else)\\s*\\(.*\\)\\s*") && !linea.trim().endsWith("{")) {
        salida.append("Error: Falta llave de apertura '{' después de la estructura de control en la línea " + numeroLinea + "\n");
        return false;
    }
    
    // Verificar si falta un punto y coma al final de la línea, excluyendo líneas que contienen solo llaves
    if (!linea.trim().endsWith(";") && !linea.trim().endsWith("{") && !linea.trim().endsWith("}") && !linea.trim().endsWith(")")) {
        salida.append("Error: Falta punto y coma al final de la línea " + numeroLinea + "\n");
        return false;
    }
    
        // Verificar si la línea anterior contiene una estructura de control y la línea actual no empieza con llave de cierre '}'.
    if (linea.trim().startsWith("{") && linea.matches("\\s*(?!if|for|while|else).*")) {
        salida.append("Error: Falta llave de cierre '}' antes de la línea " + numeroLinea + "\n");
        return false;
    }

    // Verificar si hay paréntesis faltantes
    int countParentesisAbiertos = linea.length() - linea.replace("(", "").length();
    int countParentesisCerrados = linea.length() - linea.replace(")", "").length();

    if (countParentesisAbiertos != countParentesisCerrados) {
        salida.append("Error: Paréntesis no balanceados en la línea " + numeroLinea + "\n");
        return false;
    }

    // Verificar si hay múltiples condicionales o ciclos en la misma línea, excluyendo if-else
    if ((linea.contains("if") && linea.contains("else") && !linea.contains("?")) || linea.contains("for") || linea.contains("while")) {
        salida.append("Error: Múltiples condicionales o ciclos en la línea " + numeroLinea + "\n");
        return false;
    }

    // Verificar si hay dos o más bloques "if" en la misma línea
    if (linea.split("if").length > 2) {
        salida.append("Error: Múltiples bloques 'if' en la línea " + numeroLinea + "\n");
        return false;
    }

    // Verificar comillas balanceadas
    if (!verificarComillasBalanceadas(linea)) {
        salida.append("Error: Problema con las comillas en la línea " + numeroLinea + "\n");
        return false;
    }
    
    // Verificar comentarios bien formados
    if (linea.contains("/*") && !linea.contains("*/")) {
        salida.append("Error: Comentario mal formado en la línea " + numeroLinea + "\n");
        return false;
    }

    // Verificar uso adecuado de operadores
    if (linea.matches(".*[+*/-][+*/-].*")) {
        salida.append("Error: Uso inadecuado de operadores en la línea " + numeroLinea + "\n");
        return false;
    }

    // Verificar declaración de variables
    if (linea.matches("\\s*\\w+\\s+=.*")) {
        salida.append("Error: Declaración de variable mal formada en la línea " + numeroLinea + "\n");
        return false;
    }

    // Agregar más lógica para verificar otros posibles errores de sintaxis según sea necesario
    // ...

    return true;
}

private boolean verificarBalanceoGlobal(List<String> lineas) {
    int countLlavesAbiertas = 0;
    int countLlavesCerradas = 0;

    for (String linea : lineas) {
        countLlavesAbiertas += linea.length() - linea.replace("{", "").length();
        countLlavesCerradas += linea.length() - linea.replace("}", "").length();
    }

    if (countLlavesAbiertas != countLlavesCerradas) {
        salida.append("Error: Llaves no balanceadas en el código\n");
        return false;
    }
    return true;
}

public boolean verificarCodigo(List<String> lineas) {
    boolean sintaxisCorrecta = true;

    for (int i = 0; i < lineas.size(); i++) {
        if (!verificarSintaxisLinea(lineas.get(i), i + 1)) {
            sintaxisCorrecta = false;
        }
    }

    if (!verificarBalanceoGlobal(lineas)) {
        sintaxisCorrecta = false;
    }

    return sintaxisCorrecta;
}

    // Función para verificar comillas balanceadas
    private boolean verificarComillasBalanceadas(String linea) {
        int countComillas = linea.length() - linea.replace("\"", "").length();
        return countComillas % 2 == 0;

    }

    private void guardarSalidaEnArchivo(String contenido) {
        try {
            // Crear el directorio si no existe
            File directorio = new File("ArchivosTexto");
            directorio.mkdirs();

            // Crear el archivo en el directorio
            File archivo = new File(directorio, "salida.txt");

            // Obtener el texto del JTextArea
            String texto = salida.getText();

            // Escribir el contenido en el archivo con codificación UTF-8
            FileWriter escritor = new FileWriter(archivo, StandardCharsets.UTF_8);
            BufferedWriter bufferEscritura = new BufferedWriter(escritor);
            bufferEscritura.write(texto);
            bufferEscritura.close();
            escritor.close();

            System.out.println("Salida guardada en el archivo 'salida.txt'");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al guardar la salida en el archivo: " + e.getMessage());
        }
    }
    
    private void guardarSalidaEnArchivoTS(String contenido) {
        try {
            // Crear el directorio si no existe
            File directorio = new File("ArchivosTexto");
            directorio.mkdirs();

            // Crear el archivo en el directorio
            File archivo = new File(directorio, "Tablasimbolos.txt");

            // Obtener el texto del JTextArea
            String texto = salida.getText();

            // Escribir el contenido en el archivo con codificación UTF-8
            FileWriter escritor = new FileWriter(archivo, StandardCharsets.UTF_8);
            BufferedWriter bufferEscritura = new BufferedWriter(escritor);
            bufferEscritura.write(texto);
            bufferEscritura.close();
            escritor.close();

            System.out.println("Salida guardada en el archivo 'Tablasimbolos.txt'");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al guardar la salida en el archivo: " + e.getMessage());
        }
    }
    
    private List<String> extraerExpresionesCorrectas(String texto) {
        List<String> expresiones = new ArrayList<>();
        // Algoritmo para extraer expresiones correctas del texto
        // Puedes usar expresiones regulares u otro método de búsqueda y delimitación
        // Aquí solo se presenta un esquema básico
        Pattern pattern = Pattern.compile("\\?(.*?)\\$");
        Matcher matcher = pattern.matcher(texto);
        while (matcher.find()) {
            expresiones.add(matcher.group(1));
        }
        return expresiones;
    }
    
    private void analizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarActionPerformed
        String texto = ingresoTexto.getText();
        salida.setText("");

        // Restablecer el mapa de frecuencia y tabla de símbolos antes de utilizarlas
        frecuenciaClasificaciones.clear();
        tablaDeSimbolos.clear();

        // Utilizar un mapa para rastrear los tokens por tipo
        Map<String, Set<String>> tokensPorTipo = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(texto, "\n");

        int numeroLinea = 0; // Contador de número de línea
        while (tokenizer.hasMoreTokens()) {
            numeroLinea++; // Incrementar el número de línea para cada nueva línea
            // Obtener la próxima línea y eliminar espacios en blanco al principio y al final
            String linea = tokenizer.nextToken().trim();

            // Verificar errores de sintaxis en la línea
            if (!verificarSintaxisLinea(linea, numeroLinea)) {
                // Si se encuentra un error, detener el proceso y salir del método
                return;
            }

            // Ignorar líneas que son comentarios de línea
            // Verificar si la línea contiene un comentario
            int indiceComentario = linea.indexOf("//");
            if (indiceComentario != -1) {
                // Si hay un comentario, eliminarlo de la línea
                linea = linea.substring(0, indiceComentario).trim();
            }

            // Ignorar comentarios de bloque /* */
            while (linea.contains("/*")) {
                int inicioComentario = linea.indexOf("/*");
                int finComentario = linea.indexOf("*/");
                if (finComentario != -1) {
                    // Si se encuentra el fin del comentario, eliminarlo de la línea
                    linea = linea.substring(0, inicioComentario).trim() + linea.substring(finComentario + 2).trim();
                } else {
                    // Si no se encuentra el fin del comentario, ignorar la línea actual
                    while (!linea.contains("*/") && tokenizer.hasMoreTokens()) {
                        linea = tokenizer.nextToken().trim();
                    }
                    continue;
                }
            }

            // Tokenizar la línea en palabras
            StringTokenizer lineaTokenizer = new StringTokenizer(linea);
            while (lineaTokenizer.hasMoreTokens()) {
                String token = lineaTokenizer.nextToken();
                String clasificacion = obtenerClasificacion(token);

                // Agregar el token al mapa correspondiente si no ha sido agregado previamente
                tokensPorTipo.putIfAbsent(clasificacion, new HashSet<>());
                tokensPorTipo.get(clasificacion).add(token);
                // Agregar el token y su tipo a la tabla de símbolos si no existe
                if (!tablaDeSimbolos.containsKey(token)) {
                    String id = "id" + ++contadorIds;
                    tablaDeSimbolos.put(id, clasificacion);
                    // Mapear el ID al token correspondiente
                    idToToken.put(id, token); 
                }
            }
        }

        // Construir el árbol sintáctico
        TreeMap<String, TreeMap<String, String>> arbolSintactico = construirArbolSintactico(texto);

        // Actualizar el mapa de frecuencia con los tokens únicos
        for (Set<String> tokens : tokensPorTipo.values()) {
            for (String token : tokens) {
                String clasificacion = obtenerClasificacion(token);
                frecuenciaClasificaciones.put(clasificacion, frecuenciaClasificaciones.getOrDefault(clasificacion, 0) + 1);
            }
        }

        // Mostrar los tokens agrupados por tipo
        for (Map.Entry<String, Set<String>> entry : tokensPorTipo.entrySet()) {
            // Usar String.join para unir los tokens sin espacios adicionales
            salida.append("[" + entry.getKey() + "]: " + String.join(" ", entry.getValue()) + "\n");
        }

        // Mostrar el resumen al final
        salida.append("\nResumen:\n");
        for (Map.Entry<String, Integer> entry : frecuenciaClasificaciones.entrySet()) {
            salida.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }

        // Delimitar y extraer cada expresión correcta del texto
        List<String> expresionesCorrectas = extraerExpresionesCorrectas(texto);
        guardarSalidaEnArchivo(salida.toString());
    }//GEN-LAST:event_analizarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:
        ingresoTexto.setText("");salida.setText("");
    }//GEN-LAST:event_limpiarActionPerformed
    
    // Método para mostrar la tabla de símbolos
    private void mostrarTablaDeSimbolos() {
        salida.setText(""); // Limpiar el área de salida
        salida.append("Tabla de Símbolos:\n");

        // Encabezados de columna con anchos específicos
        String header = String.format("%-10s %-30s %-20s\n", "ID", "Token", "Tipo/Clasificación");
        salida.append(header);

        // Separador de columnas
        String separator = String.format("%-10s %-30s %-20s\n", "----------", "------------------------------", "----------------------");
        salida.append(separator);

        // Datos de la tabla de símbolos
        for (Map.Entry<String, String> entry : tablaDeSimbolos.entrySet()) {
            String id = entry.getKey();
            String token = idToToken.get(id); // Obtener el token correspondiente al ID
            String tipoClasificacion = entry.getValue();

            // Formatear y agregar la fila a la salida
            String row = String.format("%-10s %-30s %-20s\n", id, token, tipoClasificacion);
            salida.append(row);
        }
    }
    
    private void tSimbolosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSimbolosActionPerformed
        // TODO add your handling code here:
        mostrarTablaDeSimbolos();
        guardarSalidaEnArchivoTS(salida.toString());
    }//GEN-LAST:event_tSimbolosActionPerformed

    private void mostrarArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarArbolActionPerformed
String texto = ingresoTexto.getText();
        salida.setText("");

        // Construir el árbol sintáctico
        TreeMap<String, TreeMap<String, String>> arbolSintactico = construirArbolSintactico(texto);

        // Mostrar los árboles sintácticos en la salida
        for (Map.Entry<String, TreeMap<String, String>> entry : arbolSintactico.entrySet()) {
            salida.append("Árbol: " + entry.getKey() + "\n");
            for (String nodo : entry.getValue().keySet()) {
                salida.append("\t" + nodo + "\n");
            }
        }
    }//GEN-LAST:event_mostrarArbolActionPerformed

    private void procesarInstruccionesTipo(String instrucciones) {
        StringTokenizer tokenizer = new StringTokenizer(instrucciones, "\n");

        while (tokenizer.hasMoreTokens()) {
            String linea = tokenizer.nextToken();
            procesarLinea(linea);
        }
    }

private void procesarLinea(String linea) {
    if (!linea.startsWith("TIPO")) {
        salida.append("Error: La línea no comienza con 'TIPO'\n");
        return;
    }

    // Eliminar el prefijo "TIPO" y dividir la línea por el signo "="
    String[] parts = linea.substring(5).split("=");

    if (parts.length != 2) {
        salida.append("Error: La sintaxis de la línea es incorrecta\n");
        return;
    }

    // Separar el tipo y el nombre de la variable
    String[] variableInfo = parts[0].trim().split("\\s+");
    if (variableInfo.length != 2) {
        salida.append("Error: La sintaxis de la línea es incorrecta\n");
        return;
    }

    String tipo = variableInfo[0];
    String nombreVariable = variableInfo[1];

    // Obtener el valor asignado
    String valor = parts[1].trim();

    if (!esTipoValido(tipo, valor)) {
        salida.append("Error: La variable '" + nombreVariable + "' de tipo '" + tipo + "' no corresponde con el valor asignado '" + valor + "'\n");
    } else {
        salida.append("Mensaje de aceptación: La variable '" + nombreVariable + "' de tipo '" + tipo + "' corresponde con el valor asignado '" + valor + "'\n");
    }
}

    private boolean esTipoValido(String tipo, String valor) {
        if (tipo.equals("int")) {
            try {
                Integer.parseInt(valor);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else if (tipo.equals("String")) {
            return valor.matches("\".*\"");
        } else {
            return false;
        }
    }
    
    private void btnTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoActionPerformed
        // Obtener el texto del área principal
        String instrucciones = ingresoTexto.getText();
        salida.setText("");

        // Procesar las instrucciones que comienzan con "TIPO"
        procesarInstruccionesTipo(instrucciones);
    }//GEN-LAST:event_btnTipoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(compiladorV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(compiladorV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(compiladorV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(compiladorV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new compiladorV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JButton analizar;
    private javax.swing.JButton btnTipo;
    private javax.swing.JButton cargarArch;
    private javax.swing.JTextArea ingresoTexto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton mostrarArbol;
    private javax.swing.JTextArea salida;
    private javax.swing.JButton tSimbolos;
    // End of variables declaration//GEN-END:variables
}
