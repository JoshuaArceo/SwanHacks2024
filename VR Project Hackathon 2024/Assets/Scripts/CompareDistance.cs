using System;
using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

public class CompareDistance : MonoBehaviour
{
    private float[] planetsActual = {0.416f,0.778f,1.075f, 1.638f, 5.596f, 10.302f, 20.645f, 32.306f};
    public GameObject[] planetsEstimated;
    public Transform[] textLoc;
    private List<Vector3> actualPositions = new List<Vector3>();
    public GameObject textField;
    private List<float> errors = new List<float>();
    private List<Vector3> estimatedPositions = new List<Vector3>();
    public void calculateError()
    {
        for (int i = 0; i < planetsEstimated.Length; i++)
        {
            actualPositions.Add(planetsEstimated[i].transform.position.normalized*planetsActual[i]);
            estimatedPositions.Add(planetsEstimated[i].transform.position);
            planetsEstimated[i].transform.rotation = Quaternion.Euler(0,0,0);
            float error = (planetsEstimated[i].transform.position.magnitude - actualPositions[i].magnitude) / actualPositions[i].magnitude * 100f;
            errors.Add(error);
            var planet = Instantiate(planetsEstimated[i], textLoc[i], false);
            planet.transform.position = actualPositions[i];
            var txt = Instantiate(textField, planet.transform, false);
            txt.transform.position = new Vector3(txt.transform.position.x,txt.transform.position.y + 0.5f, txt.transform.position.z);
            txt.transform.localScale *= 5f;
            if (error>0)
            {
                txt.GetComponentInChildren<TextMeshProUGUI>().SetText(error + "% too high");
            //Debug.Log(error + "% too high");
            }
            else
            {
                txt.GetComponentInChildren<TextMeshProUGUI>().SetText(-1*error + "% too low");
            //Debug.Log(-1*error + "% too low");
            }
        }
    }

    public List<float> GetErrors()
    {
        return errors;
    }

    public List<Vector3> GetEstimatePositions()
    {
        return estimatedPositions;
    }
}