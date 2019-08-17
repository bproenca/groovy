package file

File arqFinal = new File("D:/JavaD/_scripts/Y800/arq_gerado_com_Y800")
def contador = 0

new File("arquivo_template.txt").eachLine { line ->
  def campos = line.split('\\|')
  
  if (campos[1] == 'Y800') {
    arqFinal << ("|Y800|")
    new File("D:/JavaD/_scripts/Y800/arq_y800.rtf").eachLine { rtf ->
      if (contador > 0) arqFinal << '\n'
      arqFinal << rtf
      contador++
    }
    arqFinal << ("|Y800FIM|\n")        
  } else {
    arqFinal << ("${line}\n")
  }
}

System.console().readLine '\nProcesso finalizado com sucesso!! Click ENTER to quit'