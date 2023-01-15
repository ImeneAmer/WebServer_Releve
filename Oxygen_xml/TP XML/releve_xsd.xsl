<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
    
 <xsl:template match="/">
     
     <html>
         
         <head></head>
         
         <body>
             
             <h4> Total des Opérations Débit et Crédit </h4>
             
             <xsl:for-each select="releve">
                 
                 <ul>
                     <li> RIB: <xsl:value-of select=" @rib"></xsl:value-of></li>
                     <li> Date Releve : <xsl:value-of select=" dateReleve"></xsl:value-of></li>
                     <li> Total Débit : <xsl:value-of select="sum(operations/operation[@type='DEBIT']/@montant)"></xsl:value-of></li>
                     <li> Total Crédit : <xsl:value-of select="sum(operations/operation[@type='CREDIT']/@montant)"></xsl:value-of></li>
                 </ul> 
             </xsl:for-each>
             
             <table width="70%" border="1">
                 <tr>
                     <th> Type d'opération </th>
                     <th> Date d'opération </th>
                     <th> Montant</th>
                     <th> Description </th>
                 </tr>
             <xsl:for-each select="releve/operations/operation[@type='CREDIT']">
                 <tr>
                     <td><xsl:value-of select="@type"></xsl:value-of></td>
                     <td><xsl:value-of select="@date"></xsl:value-of></td>
                     <td> <xsl:value-of select="@montant"></xsl:value-of></td>
                     <td> <xsl:value-of select="@Description"></xsl:value-of></td>
                   
                 </tr>
             </xsl:for-each>
                 <tr>
                     <td colspan="3"> Total des opérations  </td>
                     <xsl:for-each select="releve">  <td> <xsl:value-of select="sum(operations/operation[@type='CREDIT']/@montant)"></xsl:value-of></td> </xsl:for-each>
                    
                 </tr>
             </table>
                 
         </body>
     </html>
     
     
 </xsl:template>
</xsl:stylesheet>