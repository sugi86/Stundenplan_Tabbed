package de.fhbielefeld.swe.stundenplan_tabbed;

/**
 * Created by Sugi86 on 12.01.2018.
 */
public class Fach
{
    private String semester;
    private String name;
    private String tag;
    private String beginn;
    private String ende;
    private String raum;
    private String dozent;
    private String kuerzel;
    private boolean checked;


    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getBeginn() {
        return beginn;
    }

    public void setBeginn(String beginn) {
        this.beginn = beginn;
    }

    public String getEnde() {
        return ende;
    }

    public void setEnde(String ende) {
        this.ende = ende;
    }

    public String getRaum() {
        return raum;
    }

    public void setRaum(String raum) {
        this.raum = raum;
    }

    public String getDozent() {
        return dozent;
    }

    public void setDozent(String dozent) {
        this.dozent = dozent;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean aktiv) {
        this.checked = aktiv;
    }

    public void toggle() {
        if (this.isChecked())
        {
            this.checked= false;
        }
        else
        {
            this.checked= true;
        }
    }

    public Fach(String sem, String n, String t, String b, String e, String r, String doz, String kue, boolean ak)
    {
        setSemester(sem);
        setName(n);
        setTag(t);
        setBeginn(b);
        setEnde(e);
        setRaum(r);
        setDozent(doz);
        setKuerzel(kue);
        setChecked(ak);
    }

    public Fach(){
        setSemester("0");
        setName("Musterfach");
        setTag("Sonntag");
        setBeginn("00:00");
        setEnde("25:25");
        setRaum("R666");
        setDozent("Musterdozent");
        setKuerzel("MD");
        setChecked(false);
    }

    public String CSVtoString() {
        return semester +";"+name+";"+tag+";"+beginn+";"+ende+";"+raum+";"+dozent+";"+kuerzel+";"+checked+'\n';
    }

    public String createTitleKatalog(){
        return semester +" - "+ name + " - " + tag;
    }

    public String createTitleStundenplan(){
        return semester +" - "+ name + " - " + tag;
    }

    public String createAttribute(){
        return raum +'\n' + beginn + " - " + ende + '\n' + dozent;
    }
}