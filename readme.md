GUI Automatische Blutdruckregulierung mit Medikamenten
====


Konzept
---

* Unterschiedliche Erfahrungen: Umschalten zwischen Ärzte-Display und Fuzzy-Set-Anzeige für Experten
* Konsistenz: Aufbau der Haupt-GUI analog zu den bisher vorhandenen Patientenmonitoren, so dass sich die bedienenden Ärzte nicht umgewöhnen müssen.
* Aufgabenangemessenheit: Es werden nur die notwendigsten Informationen auf der globalen Anzeige angezeigt, weiterführende Informationen befinden sich hinter weiteren Buttons. Dies verbessert die Übersichtlichkeit und zeigt auf einen Blick alle relevanten Daten.
* Geringe Belastung des Kurzzeitgedächnisses: Es wird maximal eine Ebene tiefer in den Informationen gegangen.
* Ausdrucksweise des Anwenders, Erwartungskonformität: Die Fachsprache des Anwendungsgebiets ist auf den Anzeigen der aktuellen Werte vorhanden, dort finden sich gebräuchliche medizinische Abkürzungen für die gemessenen Werte und verabreichten Medikamente.
* Selbstbeschreibungsfähigkeit: Das System warnt vor der schwerwiegenden Aktion, das Programm zu beenden, mit einer eindringlichen Warnmeldung. Wird der Medikationspause-Button gedrückt, wird dies unübersehbar visuell dargestellt.
* Klare Auswege: Aus jedem Sub-Bildschirm kann über eine sichtbar plazierte, sich immer am selben Ort befindliche Zurück-Schaltfläche zur globalen Ansicht gewechselt werden.

Das Programm startet in der globalen Anzeige. Diese enthält vier Graphen, welche die Eingabedaten der vier Sensoren über die letzten zehn Minuten visualisiert. Neben dem Graph befindet sich die Anzeige des aktuell gemessenen Eingabewerts des dazugehörigen Graphen. Neben der Zahl symbolisiert ein kleiner Pfeil, ob der Wert im Vergleich zum letzten Wert gesunken, gestiegen oder gleich geblieben ist.

Unterhalb der Graphen befinden sich sechs Schaltflächen: Die Schaltfläche links aussen dient zur Pausierung der Medikamentengabe. Neben diesem Button befinden sich vier Anzeigen, welche die Dosierung der aktuell gegebenen Medikamente anzeigt. Auch hier wird der Pfeil zur Visualisierung des Verlaufs dargestellt. Wird auf den Pausieren-Button gedrückt, verändern sich die Zahlen der Medikamentenanzeigen auf zwei Striche und blinken im Halbsekunden-Takt, um die Pausierung deutlich zu visualisieren. Außerdem verändert sich das Symbol des Pausieren-Buttons zu einem Play-Pfeil wie auf einem Kasettenrekorder. Der Button ganz rechts in der unteren Reihe befinden sich die nicht so häufig verwendeten Funktionen, weshalb diesen weniger Platz eingeräumt wird. Dort befindet sich ein Button für die Einstellungen der Software, ein Button zum Zugriff auf die Fuzzy-Sets, und ein Button zum Beenden des Programms. Beim Klick auf den Beenden-Button erscheint eine Warnung, erst nach Bestätigung dieser wird das Programm wirklich beendet.

Bei einem Klick auf den Einstellungs-Button öffnet sich ein Fenster, in dem der Name des Patienten, Gewicht, Alter, Medikamentenunverträglichkeiten etc. eingegeben werden kann. Dies wird mit einem Wizard eingegeben, um die Eingabemasken übersichtlich zu halten. Auch während der Eingabe werden die aktuellen Mess- und Medikamentenwerte angezeigt.

Bei einem Klick auf den Fuzzy-Set-Button öffnet sich ein Fenster, welches Experteninformationen zu den Fuzzy-Sets anzeigt. Bei diesen kann in der Zeit zurück- und vorgesprungen werden. Zum gewählten Zeitpunkt werden die gemessenen Input-Signale sowie deren Kategorisierung in Low, Medium und High angezeigt, die aktiven Regeln mit ihrer Wahrscheinlichkeit, sowie die daraus resultierenden Ausgabedaten. Auch hier wird rechts und unten die aktuellen Mess- und Medikamentendaten angezeigt.

Bei einem Klick auf eine Medikamenten- oder Eingabewertanzeige öffnet sich das Detail-Fenster zu diesem Wert. Beim Detail-Fenster bleiben die Medikamenten- und Eingabeanzeigen an den Rändern erhalten, damit der Benutzer diese wichtigen Daten auch auf der Detailseite im Blick hat. Im "Inneren" der Detailseite wird ein großer Graph angezeigt, welcher den Verlauf des gewählten Werts (Eingabe oder Medikament) anzeigt. Eine horizontale gestrichelte Linie zeigt an, was der Sollwert für diesen Wert ist. Der Graph wird auf der Unterseite und an der rechten Seite von Anzeigen eingerahmt, die die Eingabedaten und Medikamentendaten zum gewählten Zeitpunkt anzeigen. Ein Zeitpunkt kann durch einen Klick in den Graphen gewählt werden und wird durch eine vertikale Linie symbolisiert. Weiterhin kann durch zwei Schaltflächen in der Zeit vor- und zurückgesprungen werden.

Meta
---

###Lizenz

Lizenziert unter GPL v3 siehe *licence.txt*

###Mutige Mungos

* Brandstetter Franziska
* Eger Andreas
* Führer Maximilian
* Kammerer Moritz
